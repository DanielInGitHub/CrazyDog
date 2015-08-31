package org.crazydog.controller;

import org.crazydog.domain.DepartmentEntity;
import org.crazydog.domain.UnitEntity;
import org.crazydog.serviceI.impl.UnitServiceImpl;
import org.crazydog.serviceI.impl.searchmodel.UnitSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by never on 2015/8/28.
 */
@Controller
public class UnitController {

    @Autowired
    @Qualifier("unitServiceImpl")
    private UnitServiceImpl unitService;


    /**
     * 映射显示所有单位的页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/unit")
    public String unitManage(HttpServletRequest request, @RequestParam("page") String page) {
        List<UnitEntity> unitEntities = unitService.getAllEntities();

        request.setAttribute("unitEntities", unitEntities);

        String unitId = request.getParameter("unitId");
        if (unitId != null) {
            //取出unitEntity
            UnitEntity unitEntity = unitService.getEntity(Integer.valueOf(unitId));
            List<DepartmentEntity> departmentEntities = unitService.getDepartmentEntitiesByUnit(unitEntity);
            request.setAttribute("unitEntity", unitEntity);
            request.setAttribute("departmentEntities", departmentEntities);
        }

        return page;
    }

    /**
     * 响应删除某个单位的操作
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=unitDelete")
    public String deleteUnit(HttpServletRequest request) {
        String unitId = request.getParameter("unitId");
        UnitEntity unitEntity = new UnitEntity();
        if (unitId != null) {
            unitEntity.setId(Integer.valueOf(unitId));
        }
        unitService.deleteEntity(unitEntity);
        //重新加载一次
        return "unitManage";
    }

    /**
     * 响应修改某个单位的操作
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/unit", params = "action=unitModify")
    public String modifyUnit(HttpServletRequest request) {
        String unitId = request.getParameter("unitId");
        UnitEntity unitEntity = new UnitEntity();
        if (unitId != null) {
            unitEntity.setId(Integer.valueOf(unitId));
        }
//        unitService.deleteEntity(unitEntity);
        //重新加载一次
        return "unitManage";
    }

    @RequestMapping(value = "/unit", params = "action=search")
    public String advanceSearch(HttpServletRequest request, @RequestParam("unitCode") String unitCode, @RequestParam("unitName") String unitName) throws UnsupportedEncodingException {

        if ("".equals(unitCode) || "服务单位编码".equals(unitCode))
            unitCode = null;
        if ("".equals(unitName) || "服务单位名称".equals(unitName))
            unitName = null;

        UnitSearchModel model = new UnitSearchModel(unitCode, unitName);
        List<UnitEntity> unitEntities = unitService.advanceSearch(model);

        request.setAttribute("unitEntities", unitEntities);
        return "unitManage";
    }

    @RequestMapping(value = "/unit", params = "action=add")
    public String addUnit(HttpServletRequest request, @RequestParam("unitId") int unitId) {

        UnitEntity unitEntity = null;
        if (unitId != 0) {
            unitEntity = new UnitEntity();
            unitEntity.setId(unitId);
        }

        Map<String, String> map = request.getParameterMap();
        Set<String> set = map.keySet();
        List<DepartmentEntity> departmentEntities = new ArrayList<DepartmentEntity>(map.size() - 2);
        for (String str : set) {
            if (!"action".equals(str) && !"unitId".equals(str)) {
                String deptName = request.getParameter(str);
                if (deptName != null && !"".equals(deptName)) {
                    DepartmentEntity departmentEntity = new DepartmentEntity();
                    departmentEntity.setDeptName(deptName);
                    departmentEntity.setUnitByUnitId(unitEntity);
                    departmentEntities.add(departmentEntity);
                }
            }
        }

        unitService.addDepartments(unitEntity, departmentEntities);
        //明天把这个跳转问题解决
        return "";
//        return "forward:/unit?page=unitModify&&unitId=" + unitId;
    }
}

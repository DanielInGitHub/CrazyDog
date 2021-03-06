package org.crazydog.controller;

import org.crazydog.controller.util.GenerateArray;
import org.crazydog.domain.*;
import org.crazydog.serviceI.impl.EmployeeServiceImpl;
import org.crazydog.serviceI.impl.HireInfoServiceImpl;
import org.crazydog.serviceI.impl.ResumeServiceImpl;
import org.crazydog.serviceI.impl.UnitServiceImpl;
import org.crazydog.serviceI.impl.searchmodel.EmployeeSearchModel;
import org.crazydog.serviceI.impl.searchmodel.ResumeSearchModel;
import org.crazydog.serviceI.impl.searchmodel.UnitSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by johnny on 15-8-27.
 */
@Controller
@RequestMapping("/employeePage")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private HireInfoServiceImpl hireInfoService;

    @Autowired
    private ResumeServiceImpl resumeService;

    @Autowired
    private UnitServiceImpl unitService;


    // eg : .../employee?pages=1
    // 处理pages参数，显示相应页数的所有人员信息

    /**
     * 接收page参数（REST风格），实现人员显示
     * @param request
     * @param page
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{page}")
    public String getEmployeeByPages(HttpServletRequest request, @PathVariable String page) {
        request.setAttribute("employeesList", employeeService.getEmployeeByPage(Integer.parseInt(page)));
        request.setAttribute("page", page);
        request.setAttribute("maxPage", employeeService.maxPageNum());
        return "employeePage";
    }

    /**
     * 获取所有的已经录取的人员信息
     *
     * @return
     */
    @RequestMapping(params = "action=getAllHires")
    public String getAllHirePersons(HttpServletRequest request) {
        List<HireInfoEntity> list = hireInfoService.getAllHireEntitiesByState(ResumeSearchModel.Luqu.录取);
        request.setAttribute("hireInfoEntities", list);
        return "showAllHires";
    }

    /**
     * 给某个已经录取的员工建立档案
     *
     * @param request
     * @param resumeId
     * @return
     */
    @RequestMapping(params = "action=showToBuild")
    public String showToBuild(HttpServletRequest request, @RequestParam("resumeId") int resumeId) {
        ResumeEntity resumeEntity = resumeService.getEntity(resumeId);
        request.setAttribute("resume", resumeEntity);

        List<UnitEntity> unitEntities = unitService.getAllEntities();
        request.setAttribute("unitEntities", unitEntities);

        String script = GenerateArray.generateScript(unitService);
        request.setAttribute("script", script);

        return "buildRecord";
    }

    @RequestMapping(params = "action=buildRecord")
    public String buildRecord(HttpServletRequest request, @RequestParam("resumeId") int resumeId, @RequestParam("unitId") int unitId, @RequestParam("deptId") int deptId, @RequestParam("code") String code) {

        employeeService.buildEmployee(resumeId, unitId, deptId, code);
        //建档成功之后删除简历信息

        return getAllHirePersons(request);
    }

    /**
     * 跳转到离职人员处理
     *
     * @return
     */
    @RequestMapping(params = "leave", method = RequestMethod.GET)
    public String dealWithLeave(HttpServletRequest request, @RequestParam("empid") String empid, @RequestParam("empname") String empname) {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String needDate = format.format(date);

        request.setAttribute("empid", empid);
        request.setAttribute("empname", empname);
        request.setAttribute("date", needDate);
        return "leave";
    }

    /**
     * 跳转到调岗人员处理
     *
     * @return
     */
    @RequestMapping(params = "dispatch", method = RequestMethod.GET)
    public String dealWithDispatch(HttpServletRequest request) {

        // just get the emp id
        String empid = request.getParameter("empid");

        // get the employee from the database
        EmployeeEntity employeeEntity = employeeService.getEntity(Integer.parseInt(empid));

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String needDate = format.format(date);

        request.setAttribute("emp", employeeEntity);
        request.setAttribute("date", needDate);
        return "dispatch";
    }


    @RequestMapping(params = "action=getPositionChange")
    public String getPositionChanges(HttpServletRequest request) {
        List<PositionChangeEntity> positionChangeEntities = employeeService.getAllPositionChangeEntities();
        request.setAttribute("positionChangeEntities", positionChangeEntities);

        return "showAllPositionChanges";
    }


    /**
     * 实现人员搜索功能
     * @param request
     * @param empid
     * @param empname
     * @return
     */
    @RequestMapping(params = "action=search")
    public String advanceSearch(HttpServletRequest request, @RequestParam("empid") String empid, @RequestParam("empname") String empname) {

        if ("".equals(empid) || "人员编号".equals(empid)) {
            empid = null;
        }
        if ("".equals(empname) || "姓名".equals(empname)) {
            empname = null;
        }

        EmployeeSearchModel model = new EmployeeSearchModel(empid, empname);
        List<EmployeeEntity> employeeEntities = employeeService.advanceSearch(model);
        request.setAttribute("employeesList", employeeEntities);

        return "employeePage";
    }
}

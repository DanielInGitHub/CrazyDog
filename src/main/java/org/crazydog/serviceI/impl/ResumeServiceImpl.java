package org.crazydog.serviceI.impl;

import org.crazydog.daoI.impl.*;
import org.crazydog.domain.*;
import org.crazydog.serviceI.BaseService;
import org.crazydog.serviceI.impl.searchmodel.ResumeSearchModel;
import org.crazydog.serviceI.impl.searchmodel.SearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ResumeServiceImpl implements BaseService<ResumeEntity> {

    @Autowired
    @Qualifier("resumedaoImpl")
    private ResumedaoImpl resumedao;

    @Autowired
    @Qualifier("hireInfodaoImpl")
    private HireInfodaoImpl hiredao;

    @Autowired
    @Qualifier("resumeEdudaoImpl")
    private ResumeEdudaoImpl resumeEdudao;

    @Autowired
    @Qualifier("resumeFamilydaoImpl")
    private ResumeFamilydaoImpl resumeFamilydao;

    @Autowired
    @Qualifier("resumeJobsdaoImpl")
    private ResumeJobsdaoImpl resumeJobsdao;


    @Autowired
    protected HibernateTemplate hibernateTemplate;

    /**
     * 使用resumeSearchModel来进行高级查询
     *
     * @param searchModel
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<ResumeEntity> advanceSearch(ResumeSearchModel searchModel) {
        String hql = SearchModel.advanceSearch(searchModel);
        if (hql != null) {
            System.out.println(hql);
            List<Object[]> list = (List<Object[]>) resumedao.find(hql);
            List<ResumeEntity> resumes2 = new ArrayList<ResumeEntity>();
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                Object[] b = (Object[]) list.get(i);
                ResumeEntity resume = (ResumeEntity) b[0];
                HireInfoEntity h = (HireInfoEntity) b[1];
                resume.setHireById(h);
                resumes2.add(resume);
            }
            return resumes2;
        } else return new ArrayList<ResumeEntity>(0);
    }

    /**
     * 增加一份简历
     *
     * @param t 简历的实例对象
     * @return
     */
    public void addEntity(ResumeEntity t) {
        resumedao.addEntity(t);
    }

    /**
     * 修改一份简历
     *
     * @param t 简历的实例对象
     * @return
     */
    public void modifyEntity(ResumeEntity t) {
        resumedao.modifyEntity(t);
    }

    /**
     * 获取所有的简历
     *
     * @return 一个所有简历的list对象
     */
    public List<ResumeEntity> getAllEntities() {
        return (List<ResumeEntity>) resumedao.getAllEntities();
    }

    /**
     * 删除一份简历
     *
     * @param t 简历的实例对象
     * @return
     */
    public void deleteEntity(ResumeEntity t) {
        resumedao.deleteEntity(t);
    }

    /**
     * 获取一份简历
     *
     * @param id 简历的id
     * @return load方法加载的一个简历对象
     */
    public ResumeEntity loadEntity(int id) {
        return resumedao.loadEntity(id);
    }

    /**
     * 获取一份简历
     *
     * @param id 简历的id
     * @return get方法加载的一个简历对象
     */
    public ResumeEntity getEntity(int id) {
        return (ResumeEntity) resumedao.getEntity(id);
    }

    /**
     * 通过姓名,学历,录取状体查询简历,所以，返回一个list对象 调用的是父类的find实现方法
     *
     * @param hql 根据获取到的查询条件生成的hql语句
     * @return 符合条件的list对象
     */
    public List<Object> queryEntity(String hql) {
        return hibernateTemplate.getSessionFactory().openSession().createQuery(hql).list();
    }

    /**
     * 通过姓名,学历,录取状体查询简历,增加分页的查询功能 调用的是父类的find实现方法
     *
     * @param hql 根据获取到的查询条件生成的hql语句
     * @return 符合条件的list对象
     */
    public List<ResumeEntity> queryEntity(String hql,
                                          Map<String, Object> params, int page, int rows) {
        return (List<ResumeEntity>) resumedao.find(hql, params, page, rows);
    }

    /**
     * 批量录取
     *
     * @param id 保存的是选择界面所有被选择的复选框的value，值是相应的简历对象的id
     */
    public void batchHire(int[] id, String name) {
        for (int i : id) {
            HireInfoEntity hire = hiredao.getHireInfoByResumeId(i);
            hire.setState("录取");
            hire.setOperateTime(new java.sql.Date(new java.util.Date().getTime()));
            hire.setOperator(name);
            hiredao.modifyEntity(hire);
        }
    }

    /**
     * 批量取消录取
     *
     * @param id   保存的是选择界面所有被选择的复选框的value，值是相应的简历对象的id
     * @param name 操作人姓名
     */
    public void batchcancelHire(int[] id, String name) {
        for (int i : id) {
            HireInfoEntity hire = hiredao.getHireInfoByResumeId(i);
            hire.setState("未录取");
            hire.setOperateTime(new java.sql.Date(new java.util.Date().getTime()));
            hire.setOperator(name);
            hiredao.modifyEntity(hire);
        }
    }

    /**
     * 通过录取信息的id取消录取
     *
     * @param id   被取消的id
     * @param name 操作人的姓名
     */
    public void cancelHire(int id, String name) {
        HireInfoEntity hire;
        hire = (HireInfoEntity) hiredao.getEntity(id);
        hire.setState("通过");
        hire.setOperateTime(new java.sql.Date(new java.util.Date().getTime()));
        hire.setOperator(name);
        hiredao.modifyEntity(hire);
    }

    /**
     * 通过简历的id取消录取
     *
     * @param resumeid 被取消的简历的id
     * @param name     操作人的姓名
     */
    public void cancelHireByresumeId(int resumeid, String name) {
        HireInfoEntity hire = (HireInfoEntity) hiredao.getHireInfoByResumeId(resumeid);
        hire.setState("未录取");
        hire.setOperateTime(new java.sql.Date(new java.util.Date().getTime()));
        hire.setOperator(name);
        hiredao.modifyEntity(hire);
    }

    /**
     * 删除一条教育经历记录
     *
     * @param id 教育经历的id
     */
    public void deleteEdu(int id) {
        resumeEdudao.deleteEntity(resumeEdudao.getEntity(id));
    }

    /**
     * 添加一条教育经历记录
     *
     * @param t 一条教育经历记录
     */
    public void addEdu(ResumeEduEntity t) {
        resumeEdudao.addEntity(t);
    }

    /**
     * 删除一条家庭成员记录
     *
     * @param id 教育经历的id
     */
    public void deleteFamily(int id) {
        resumeFamilydao.deleteEntity(resumeFamilydao.getEntity(id));
    }

    /**
     * 添加一条家庭成员记录
     *
     * @param t 一条教育经历记录
     */
    public void addFamily(ResumeFamilyEntity t) {
        resumeFamilydao.addEntity(t);
    }

    /**
     * 删除一条工作经历记录
     *
     * @param id 教育经历的id
     */
    public void deleteJob(int id) {
        resumeJobsdao.deleteEntity(resumeJobsdao.getEntity(id));
    }

    /**
     * 添加一条工作经历记录
     *
     * @param t 一条教育经历记录
     */
    public void addJob(ResumeJobsEntity t) {
        resumeJobsdao.addEntity(t);
    }

    /**
     * 查询所有的教育经历记录
     *
     * @return 所有的教育经历记录
     */
    public List<ResumeEduEntity> queryAllEdu() {
        return (List<ResumeEduEntity>) resumeEdudao.getAllEntities();
    }

    /**
     * 查询所有的工作经历记录
     *
     * @return 所有的工作经历记录
     */
    public List<ResumeJobsEntity> queryAllJob() {
        return (List<ResumeJobsEntity>) resumeJobsdao.getAllEntities();
    }

    /**
     * 查询所有的家庭成员
     *
     * @return 所有的家庭成员记录
     */
    public List<ResumeFamilyEntity> queryAllFamily() {
        return (List<ResumeFamilyEntity>) resumeFamilydao.getAllEntities();
    }


    /**
     * 批量删除
     *
     * @param id 保存的是选择界面所有被选择的复选框的value，值是相应的简历对象的id
     */
    public void batchdeleteresume(int[] id) {
        for (int i : id) {
            ResumeEntity resume = resumedao.loadEntity(i);
            resumedao.deleteEntity(resume);
        }
    }


    /**
     * 将前提获取的String[] id 转换为int[]
     *
     * @param String[] 保存的是选择界面所有被选择的复选框的value，值是相应的简历对象的id
     */
    public int[] stringtoint(String[] ids) {
        int[] id = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            id[i] = Integer.parseInt(ids[i]);
        }
        return id;
    }

    /*
      分页查询简历记录
     */
    public List<ResumeEntity> getResumeByPage(int page) {
        String hql = "from ResumeEntity res"; // left join emp.unitEntity unit left join emp.departmentEntity depart left join emp.contractEntity cont";
        List<ResumeEntity> resumes = (List<ResumeEntity>) resumedao.find(hql, page, 5);
        return resumes;
    }
}

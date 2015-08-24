package org.crazydog.daoI;

import org.crazydog.domain.ResumeEntity;

import java.util.List;

/**
 * 对简历实体进行操作
 * Created by never on 2015/8/23.
 */
public interface ResumedaoI {
    /**
     * 增加简历
     *
     * @param entity 简历实例
     */
    void addResume(ResumeEntity entity);

    /**
     * 修改简历
     *
     * @param entity 简历实例
     */
    void modifyResume(ResumeEntity entity);

    /**
     * 删除简历
     *
     * @param id 简历的id
     */
    void deleteResume(int id);

    /**
     * 获取指定的简历
     *
     * @param id 简历的id
     * @return
     */
    ResumeEntity getResume(int id);

    /**
     * 获取所有的简历
     *
     * @return
     */
    List<ResumeEntity> getAllResumes();
}

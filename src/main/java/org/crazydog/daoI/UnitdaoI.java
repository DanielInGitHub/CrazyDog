<<<<<<< HEAD
package org.crazydog.daoI;

import org.crazydog.domain.UnitEntity;

import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
public interface UnitdaoI {
    /**
     * 增加服务单位
     *
     * @param entity 服务单位实例
     */
    void addUnit(UnitEntity entity);

    /**
     * 修改服务单位
     *
     * @param entity 服务单位实例
     */
    void modifyUnit(UnitEntity entity);

    /**
     * 删除服务单位
     *
     * @param id 服务单位的id
     */
    void deleteUnit(int id);

    /**
     * 获取指定的服务单位
     *
     * @param id 服务单位的id
     * @return
     */
    UnitEntity getUnit(int id);

    /**
     * 获取所有的服务单位
     *
     * @return
     */
    List<UnitEntity> getAllUnits();
}
=======
package org.crazydog.daoI;

import org.crazydog.domain.UnitEntity;

import java.util.List;

/**
 * Created by never on 2015/8/23.
 */
public interface UnitdaoI {
    /**
     * 增加服务单位
     *
     * @param entity 服务单位实例
     */
    void addUnit(UnitEntity entity);

    /**
     * 修改服务单位
     *
     * @param entity 服务单位实例
     */
    void modifyUnit(UnitEntity entity);

    /**
     * 删除服务单位
     *
     * @param entity 服务单位的id
     */
    void deleteUnit(UnitEntity entity);

    /**
     * 获取指定的服务单位
     *
     * @param id 服务单位的id
     * @return
     */
    UnitEntity getUnit(int id);

    /**
     * 获取所有的服务单位
     *
     * @return
     */
    List<UnitEntity> getAllUnits();
}
>>>>>>> bcd33826cccc6660b1d060c59ac9e26753337c6e

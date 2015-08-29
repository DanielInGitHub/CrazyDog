package org.crazydog.serviceI.impl;

import org.crazydog.domain.tmp.UnitEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by never on 2015/8/25.
 */
public class UnitServiceImplTest {
    ApplicationContext applicationContext;
    UnitServiceImpl unitService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("test-application-config.xml");
        unitService = (UnitServiceImpl) applicationContext.getBean("unitServiceImpl");
    }

    @Test
    public void testGetUnitByName() throws Exception {

    }

    @Test
    public void testGetUnitByCode() throws Exception {

    }

    @Test
    public void testAddDepartments() throws Exception {

    }

    @Test
    public void testAddEntity() throws Exception {

    }

    @Test
    public void testModifyEntity() throws Exception {

    }

    @Test
    public void testLoadEntity() throws Exception {

    }

    @Test
    public void testGetEntity() throws Exception {

    }

    @Test
    public void testGetAllEntities() throws Exception {
        System.out.println(unitService.getClass());
        List<UnitEntity> unitEntities = unitService.getAllEntities();
        for (UnitEntity unitEntity : unitEntities)
            System.out.println(unitEntity);
    }

    @Test
    public void testDeleteEntity() throws Exception {

    }
}
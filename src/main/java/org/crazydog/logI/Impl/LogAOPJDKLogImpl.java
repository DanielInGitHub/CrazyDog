package org.crazydog.logI.Impl;

import org.aspectj.lang.JoinPoint;
import org.crazydog.logI.LogAOPI;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by never on 2015/9/8.
 */
@Component
public class LogAOPJDKLogImpl implements LogAOPI {
    private static final Logger LOGGER = Logger.getLogger("org.crazydog");

    public void log(JoinPoint point) {
//        LOGGER.info("start to enter the method " + point.getSignature());
        LOGGER.entering(point.getTarget().getClass().toString(), "start to enter the method [" + point.getSignature() + "]");
    }

    //有参无返回值的方法
    public void logArgWithoutReturn(JoinPoint point) {
        //此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
        Object[] args = point.getArgs();
        LOGGER.info("目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                LOGGER.info(obj + ",");
            }
        }
    }

    //有参并有返回值的方法
    public void logArgWithReturn(JoinPoint point, Object returnObj) {
        //此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
        Object[] args = point.getArgs();
        LOGGER.info("目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                LOGGER.info(obj + ",");
            }
            LOGGER.info("执行结果是：" + returnObj);
        }
    }
}

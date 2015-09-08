package org.crazydog.logI.Impl;

import org.aspectj.lang.JoinPoint;
import org.crazydog.logI.LogAOPI;
import org.springframework.stereotype.Component;

/**
 * 此类主要是向控制台打印来输出日志
 * Created by never on 2015/9/8.
 */
@Component
public class LogAOPConsoleImpl implements LogAOPI {

    public void log(JoinPoint point) {
        System.out.println("start to enter the method" + point.getSignature());
    }

    //有参无返回值的方法
    public void logArgWithoutReturn(JoinPoint point) {
        //此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
        Object[] args = point.getArgs();
        System.out.println("目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                System.out.println(obj + ",");
            }
            System.out.println();
        }
    }

    //有参并有返回值的方法
    public void logArgWithReturn(JoinPoint point, Object returnObj) {
        //此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
        Object[] args = point.getArgs();
        System.out.println("目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                System.out.println(obj + ",");
            }
            System.out.println();
            System.out.println("执行结果是：" + returnObj);
        }
    }
}

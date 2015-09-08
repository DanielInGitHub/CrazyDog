package org.crazydog.logI;

import org.aspectj.lang.JoinPoint;

/**
 * Created by never on 2015/9/8.
 */
public interface LogAOPI {
    //无参的日志方法
    public void log(JoinPoint point);

    //有参的日志方法
    public void logArgWithoutReturn(JoinPoint point);

    //有参有返回值的方法
    public void logArgWithReturn(JoinPoint point, Object returnObj);
}

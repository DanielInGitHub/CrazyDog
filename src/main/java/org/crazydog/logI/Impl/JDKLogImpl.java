package org.crazydog.logI.Impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.crazydog.logI.LogAOPI;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by never on 2015/9/8.
 */
@Component
public class JDKLogImpl implements LogAOPI {

    private static final Logger LOGGER = Logger.getLogger("org.crazydog");

    /**
     * Before
     * 在核心业务执行前执行，不能阻止核心业务的调用。
     * <p>
     * 无参的日志方法
     * <p>
     * 此处意在执行核心业务逻辑前，做一些安全性的判断等等
     * 可通过joinPoint来获取所需要的内容
     *
     * @param point
     */
    public void beforeAdvice(JoinPoint point) {
        LOGGER.entering(point.getTarget().getClass().toString(), "start to enter the method [" + point.getSignature() + "]");
        LOGGER.info("start to enter the method [" + point.getSignature() + "]");
    }

    /**
     * After
     * 核心业务逻辑退出后（包括正常执行结束和异常退出），执行此Advice
     * <p>
     * 有参的日志方法
     * <p>
     * 此处意在执行核心业务逻辑之后，做一些日志记录操作等等
     * 可通过joinPoint来获取所需要的内容
     *
     * @param point
     */
    public void afterAdvice(JoinPoint point) {
        Object[] args = point.getArgs();
        LOGGER.info("目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                LOGGER.info(obj + ",");
            }
        }
    }

    /**
     * Around
     * 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
     * <p>
     * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice
     * 执行完AfterAdvice，再转到ThrowingAdvice
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        //调用目标方法之前的逻辑
        beforeAdvice(pjp);

        //调用核心逻辑
        Object returnObj = pjp.proceed();

        //调用目标方法之后的逻辑
        afterReturningAdvice(pjp, returnObj);

        return returnObj;
    }

    /**
     * AfterReturning
     * 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此Advice
     * <p>
     * 有参有返回值的方法
     * <p>
     * 此处可以对返回值做进一步处理
     * 可通过joinPoint来获取所需要的内容
     *
     * @param point
     * @param returnObj
     */
    public void afterReturningAdvice(JoinPoint point, Object returnObj) {
        Object[] args = point.getArgs();
        LOGGER.info("目标参数列表：");
        if (args != null) {
            for (Object obj : args) {
                LOGGER.info(obj + ",");
            }
            LOGGER.info("执行结果是：" + returnObj);
            LOGGER.exiting(point.getTarget().getClass().toString(), "执行结果是：" + returnObj);
        }
    }

    /**
     * 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息
     * <p>
     * 注意：执行顺序在Around Advice之后
     * <p>
     * 此处意在执行核心业务逻辑出错时，捕获异常，并可做一些日志记录操作等等
     * 可通过joinPoint来获取所需要的内容
     *
     * @param joinPoint
     * @param ex
     */
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        LOGGER.severe(" 错误信息：" + ex.getMessage());
    }
}

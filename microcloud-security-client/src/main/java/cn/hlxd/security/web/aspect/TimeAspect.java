package cn.hlxd.security.web.aspect;/**
 * @Author Administrator
 * @Date 2018/7/12 15:06
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  15:06
 * @Description：
 **/


/*
* Interceptor拦截器无法获取方法内传输的属性值,弄想获取属性则采用Aspect切片
* 切片类主要分为2个部分:  1.切入点(注解)  2.增强(方法)
* 切入点分为:1.在哪些方法上起作用,  2.在什么时候起作用
* 增强: 起作用时执行的业务逻辑
*
* */
/*@Aspect
@Component*/
public class TimeAspect {
    @Around("execution(* cn.hlxd.security.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Aspect:    "+"time aspect start");

        Object[] args = pjp.getArgs();
        for (Object arg:args){
            System.out.println("Aspect:  属性:  "+arg);
        }

        Long start = new Date().getTime();

        Object object = pjp.proceed();
        System.out.println("Aspect:    "+"time aspect 耗时:" + (new Date().getTime()-start));
        System.out.println("Aspect:    "+"time aspect finish");

        return object;
    }
}

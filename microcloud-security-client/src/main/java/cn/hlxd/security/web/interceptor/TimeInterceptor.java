package cn.hlxd.security.web.interceptor;/**
 * @Author Administrator
 * @Date 2018/7/12 14:43
 */

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  14:43
 * @Description：
 **/
/*
*
*Filter只能拿到http的访问请求,无法拿到请求中的哪个方法来处理的,若需要这些信息,则需要Interceptor拦截器
* afterCompletion 不管是正常还是异常都会执行
* 则需要Interceptor拦截器 无法获取方法内传输的属性值,弄想获取属性则采用Aspect切片
* */
//@Component
public class TimeInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor:  "+"perHandle");

        System.out.println("Interceptor:  "+((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println("Interceptor:  "+((HandlerMethod)handler).getMethod().getName());

        request.setAttribute("startTime",new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor:  "+"postHandle");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("Interceptor:  "+"Time interceptor 耗时: "+ (new Date().getTime()-start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor:  "+"afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("Interceptor:  "+"Time interceptor 耗时: "+ (new Date().getTime()-start));
        System.out.println("Interceptor:  "+"ex is " + ex);
    }
}

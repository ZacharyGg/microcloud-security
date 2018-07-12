package cn.hlxd.security.web.filter;/**
 * @Author Administrator
 * @Date 2018/7/12 14:25
 */

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  14:25
 * @Description：
 **/


/*
* 自定义过滤器,加入容器访问都会经过过滤器
* 但是第三方的过滤器一般不会有Component ,就需要配置注册进去
* Filter是javaee定义
* 只能拿到http的访问请求,无法拿到请求中的哪个方法来处理的,若需要这些信息,则需要Interceptor拦截器
* */
//@Component
public class TimeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter:  "+"time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter:  "+"time filter is start");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Filter:  "+"time filter 耗时:" + (new Date().getTime()-start));
        System.out.println("Filter:  "+"time filter is finish");
    }

    @Override
    public void destroy() {
        System.out.println("Filter:  "+"time filter destroy");
    }
}

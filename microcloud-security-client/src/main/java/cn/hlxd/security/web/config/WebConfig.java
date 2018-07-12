package cn.hlxd.security.web.config;/**
 * @Author Administrator
 * @Date 2018/7/12 14:36
 */

import cn.hlxd.security.web.filter.TimeFilter;
import cn.hlxd.security.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  14:36
 * @Description：
 **/

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        /*
        * 这里可以设定过滤器在哪些URLS里面其作用,而Component是所有的需要经过
        * */
        List<String> urls =new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }

//    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor);
    }

//    /*
//    * 异步处理拦截器
//    * */
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        super.configureAsyncSupport(configurer);
//    }
}

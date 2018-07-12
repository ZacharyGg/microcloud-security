package cn.hlxd.security.service.impl;/**
 * @Author Administrator
 * @Date 2018/7/12 11:47
 */

import cn.hlxd.security.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  11:47
 * @Description：
 **/

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting test");
        return "hello  "+ name ;
    }
}

package cn.hlxd.security.controller;/**
 * @Author Administrator
 * @Date 2018/7/11 19:36
 */

import cn.hlxd.security.dto.User;
import cn.hlxd.security.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.runners.Parameterized;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-11  19:36
 * @Description：
 **/

@RestController
public class UserController {

//    不加参数
//    @GetMapping("/user")
//    public List<User> getUser() {
//        List<User> userList= new ArrayList<>();
//        userList.add(new User());
//        userList.add(new User());
//        userList.add(new User());
//        return userList;
//    }

    //@RequestParam 访问需要带参数，不然报错
    //@RequestParam(required = false) 访问不是必须需要带参数
    //@RequestParam(name ="" )  别名    以上可以合起来一起写
    //UserQueryCondition condition  当查询条件较多时,可以封装对象进行查询
    //Pageable MVC自动分页
    @GetMapping("/user")
    public List<User> getUser(UserQueryCondition condition,@PageableDefault(page = 2,size = 17,sort = "username,desc") Pageable pageable) {

        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> userList= new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }
}

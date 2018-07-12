package cn.hlxd.security.web.controller;/**
 * @Author Administrator
 * @Date 2018/7/11 19:36
 */

import cn.hlxd.security.dto.User;
import cn.hlxd.security.dto.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("/user")
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


    /*
    * @RequestParam 访问需要带参数，不然报错
    * @RequestParam(required = false) 访问不是必须需要带参数
    * @RequestParam(name ="" )  别名    以上可以合起来一起写
    * UserQueryCondition condition  当查询条件较多时,可以封装对象进行查询
    * Pageable MVC自动分页
    * */
    /*
    * @JsonView注解,使用场景:当返回的User对象里面敏感信息不想让方法获取,可用JsonView去做屏蔽
    * 使用步骤:1.使用接口来声明多个视图
    *         2.在值对象的get方法上指定视图
    *         3.在Controller方法上指定视图
    * */
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
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

    /*@PathVariable  Mapping里面的字段转换成属性
    * /user/{id}  是传属性
    * "/user/{id:\\d+}"  加入正则 ,只能接收数字
    * */
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam(value = "用户ID") @PathVariable String id){
            /*
            * 自定义异常信息
            * 1.页面异常:在resources下建立resources/error/404  这种样式的页面
            * 2.APP异常: 自定义异常->ExceptionHandlerController
            * */
//        throw new  RuntimeException(id);
//          throw new  UserNotExistException(id);
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    /*
    * @RequestBody  带这个参数才能接收参数数据
    * 时间数据的传输统一采用时间戳
    * org.hibernate.validator ,对对象进行校验时候采用validator进行校验,需要@Valid注解
    * BindingResult:当采用了validator后校验不合格后连方法都无法进入,采用binding后可使进入方法,并能获取错误信息
    * */
    @PostMapping
    public User createUser(@Valid @RequestBody User user, BindingResult errors){
        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error-> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        user.setId("1");
        return user;
    }
    /*
    *  FieldError fieldError  可以将校验信息传给前台
    *  validator 可以自定义
    * */
    @PutMapping("/{id:\\d+}")
    public User updateUser(@Valid @RequestBody User user, BindingResult errors){
        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error-> {
                FieldError fieldError =(FieldError)error;
                String message = fieldError.getField()+":   "+error.getDefaultMessage();
                System.out.println(message);
            });
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }
}

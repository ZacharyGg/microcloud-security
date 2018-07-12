package cn.hlxd.security.validator;/**
 * @Author Administrator
 * @Date 2018/7/12 11:35
 */

import cn.hlxd.security.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  11:35
 * @Description：
 **/

public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object>{

    /*
    * 可以使用Spring容器内的任何东西
    * */
    @Autowired
    public HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    /*
    * return true 校验通过, false 校验未通过
    * */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("Tom");
        System.out.println(value);
        System.out.println(context);
        return false;
    }
}

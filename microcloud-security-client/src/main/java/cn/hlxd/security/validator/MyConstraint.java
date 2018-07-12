package cn.hlxd.security.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Administrator
 * @Date 2018/7/12 11:30
 */


@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
    String message() default "{MyConstraint.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

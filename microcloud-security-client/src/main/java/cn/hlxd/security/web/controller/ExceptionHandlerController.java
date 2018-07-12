package cn.hlxd.security.web.controller;/**
 * @Author Administrator
 * @Date 2018/7/12 14:16
 */

import cn.hlxd.security.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  14:16
 * @Description：
 **/
@ControllerAdvice
public class ExceptionHandlerController {


    /*
    * 只要抛出 UserNotExistException 的异常都会经过这里进行处理.  SpringMvc也有自己的异常体系,这里是自定义
    * */
    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotExistException(UserNotExistException ex){
        Map<String,Object> result =new HashMap<>();
        result.put("id",ex.getId());
        result.put("message",ex.getMessage());
        return result;
    }
}

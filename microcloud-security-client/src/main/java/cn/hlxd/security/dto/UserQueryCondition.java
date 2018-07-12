package cn.hlxd.security.dto;/**
 * @Author Administrator
 * @Date 2018/7/11 20:40
 */

import io.swagger.annotations.ApiModelProperty;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-11  20:40
 * @Description：
 **/

public class UserQueryCondition {

    @ApiModelProperty(value = "用户名称")
    private String username;
    @ApiModelProperty(value = "年龄起始")
    private int age;
    @ApiModelProperty(value = "年龄结束")
    private int ageTo;
    private String xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }
}

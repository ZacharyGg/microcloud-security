package cn.hlxd.security.exception;/**
 * @Author Administrator
 * @Date 2018/7/12 14:06
 */

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  14:06
 * @Description：
 **/

public class UserNotExistException extends RuntimeException{


    private String id;

    public UserNotExistException(String id) {

        super("user not exist");
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

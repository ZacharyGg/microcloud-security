package cn.hlxd.security.web.async;/**
 * @Author Administrator
 * @Date 2018/7/12 16:28
 */

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  16:28
 * @Description：
 **/

@Component
public class DeferredResultHolder {
    private Map<String,DeferredResult<String>> map =new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}

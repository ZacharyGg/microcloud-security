package cn.hlxd.security.web.async;/**
 * @Author Administrator
 * @Date 2018/7/12 16:03
 */

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;


/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  16:03
 * @Description：
 **/

@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/order")
    public String order() throws InterruptedException {
        logger.info("主线程开始");
        Thread.sleep(1000);
        logger.info("主线程结束");
        return "success";
    }


    /*
    * Callable必须由主线程调副线程才能使用
    * 实际使用一般走消息队列的话就不行,接收请求的应用和处理应用不在一个应用内.
    * */
    @GetMapping("/callorder")
    public Callable<String> callorder(){
        logger.info("主线程开始");

        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程结束");
                return "success";
            }
        };
        logger.info("主线程结束");
        return result;
    }

    @Autowired
    private SimulateQueue simulateQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    /*
    * DeferredResult<String> 可配合消息队列进行使用
    * */
    @GetMapping("/deferredorder")
    public DeferredResult<String> deferredorder() throws InterruptedException {
        logger.info("主线程开始");

        String orderNumber = RandomStringUtils.randomNumeric(8);
        simulateQueue.setPlaceOrder(orderNumber);

        DeferredResult<String>  result  =new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber,result);

        logger.info("主线程结束");
        return result;
    }
}

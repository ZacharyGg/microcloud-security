package cn.hlxd.security.web.async;/**
 * @Author Administrator
 * @Date 2018/7/12 16:49
 */

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  16:49
 * @Description：
 **/


@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SimulateQueue simulateQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        new Thread(()->{
            while (true){
                if (StringUtils.isNotBlank(simulateQueue.getCompleteOrder())){
                    String orderNumber = simulateQueue.getCompleteOrder();
                    logger.info("返回订单处理结果:" + orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");

                    simulateQueue.setCompleteOrder(null);
                }else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }

        }).start();
    }
}

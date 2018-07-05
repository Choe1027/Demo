package com.choe.applicationevent.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author cyk
 * @date 2018/7/5/005 13:49
 * @email choe0227@163.com
 * @desc  发布线程，发布事件
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Component
public class EventPublisher {

   @Autowired
   private ApplicationContext applicationContext;


   public void publish(CommonEvent commonEvent){

       applicationContext.publishEvent(commonEvent);
   }
}

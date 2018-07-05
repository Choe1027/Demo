package com.choe.applicationevent.service;

import com.choe.applicationevent.constant.EventCode;
import com.choe.applicationevent.domain.OrderBean;
import com.choe.applicationevent.events.CommonEvent;
import com.choe.applicationevent.events.EventMsg;
import com.choe.applicationevent.events.EventPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyk
 * @date 2018/7/5/005 14:03
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
public class OrderService extends BaseService{

    @Autowired
    private EventPublisher publisher;

    public void commintOrder(){
        OrderBean order = new OrderBean();
        order.setTotalMoney(500);
        List<String> goods = new ArrayList<>();
        goods.add("苹果");
        goods.add("梨子");
        order.setGoods(goods);
        System.out.println("提交订单，等待支付");
        EventMsg eventMsg = new EventMsg();
        eventMsg.setEventCode(EventCode.Event_pay);
        eventMsg.setEventBody(order);
        CommonEvent commonEvent = new CommonEvent(this,eventMsg) ;
        publisher.publish(commonEvent);
    }

    @Override
    public void processEvent(CommonEvent event) {

    }
}

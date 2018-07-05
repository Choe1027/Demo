package com.choe.applicationevent.service;

import com.choe.applicationevent.constant.EventCode;
import com.choe.applicationevent.domain.OrderBean;
import com.choe.applicationevent.events.CommonEvent;
import com.choe.applicationevent.events.EventMsg;

import org.springframework.stereotype.Service;

/**
 * @author cyk
 * @date 2018/7/5/005 14:11
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
public class PayService extends BaseService{


    public void pay(OrderBean orderBean){

        StringBuilder sb = new StringBuilder();
        orderBean.getGoods().forEach(s -> {
            sb.append(s).append(",");
        });
        System.out.println("商品有"+sb.toString()+"总共"+orderBean.getTotalMoney());
    }

    @Override
    public void processEvent(CommonEvent event) {
        EventMsg eventMsg = event.getEventMsg();
        EventCode eventCode = eventMsg.getEventCode();
        Object eventBody = eventMsg.getEventBody();
        Integer code = eventCode.getCode();
        switch (code){

            case 1:{
                System.out.println("收到支付通知");
                if (eventBody instanceof OrderBean){
                    pay((OrderBean) eventBody);
                }
                break;
            }
        }
    }
}

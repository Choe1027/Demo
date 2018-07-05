package com.choe.applicationevent.events;

import org.springframework.context.ApplicationListener;

/**
 * @author cyk
 * @date 2018/7/5/005 14:22
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public abstract class EventProcessor implements ApplicationListener<CommonEvent> {
    @Override
    public void onApplicationEvent(CommonEvent event) {
        processEvent(event);
    }

    public abstract void processEvent(CommonEvent event);
}

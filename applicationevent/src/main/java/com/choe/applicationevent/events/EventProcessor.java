package com.choe.applicationevent.events;

import org.springframework.context.ApplicationListener;

/**
 * @author cyk
 * @date 2018/7/5/005 14:22
 * @email choe0227@163.com
 * @desc 处理事件的类，需要处理事件的类，都必须继承这个类
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

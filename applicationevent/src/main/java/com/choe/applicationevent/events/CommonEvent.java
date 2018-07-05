package com.choe.applicationevent.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author cyk
 * @date 2018/7/5/005 11:51
 * @email choe0227@163.com
 * @desc 通用的事件
 * @modifier
 * @modify_time
 * @modify_remark
 */
public  class CommonEvent extends ApplicationEvent {

    protected EventMsg eventMsg;

    public CommonEvent(Object source) {
        super(source);
    }

    public CommonEvent(Object source, EventMsg eventMsg) {
        super(source);
        this.eventMsg = eventMsg;
    }

    public EventMsg getEventMsg() {
        return eventMsg;
    }

    public void setEventMsg(EventMsg eventMsg) {
        this.eventMsg = eventMsg;
    }
}

package com.choe.applicationevent.events;

import com.choe.applicationevent.constant.EventCode;

/**
 * @author cyk
 * @date 2018/7/5/005 14:00
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class EventMsg {

    private EventCode eventCode;
    private Object eventBody;

    public EventCode getEventCode() {
        return eventCode;
    }

    public void setEventCode(EventCode eventCode) {
        this.eventCode = eventCode;
    }

    public Object getEventBody() {
        return eventBody;
    }

    public void setEventBody(Object eventBody) {
        this.eventBody = eventBody;
    }
}

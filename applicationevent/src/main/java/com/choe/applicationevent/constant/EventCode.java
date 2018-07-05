package com.choe.applicationevent.constant;

/**
 * @author cyk
 * @date 2018/7/5/005 11:54
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public enum  EventCode {
    Event_unknown(0,"未知消息"),
    Event_pay(1,"支付通知")
    ;

    private Integer code;
    private String decription;

    EventCode(Integer code, String decription) {
        this.code = code;
        this.decription = decription;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    /**
     * 遍历事件类型
     * @param code
     * @return
     */
    public static EventCode forCode(Integer code){
        for (EventCode eventCode : EventCode.values()){
            if (code.equals(eventCode.getCode())){

                return eventCode;
            }
        }
        return Event_unknown;
    }
}

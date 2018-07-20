package com.choe.designmodel.singleton;

import java.util.Calendar;

/**
 * @author cyk
 * @date 2018/7/20/020 14:52
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class XCalendar {

    protected Calendar calendar;


    public XCalendar() {
       if (calendar == null){
           System.out.println("init calendar....");
           calendar = Calendar.getInstance();
       }
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}

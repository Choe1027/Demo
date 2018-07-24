package com.choe.threadtest.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyk
 * @date 2018/7/24/024 10:12
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Store {

    public static int capacity = 20;

    private List<String> list = new ArrayList<>();

    public Store() {

    }

    public synchronized void add(String msg){
        list.add(msg);
    }

    public synchronized String remove(int index){

       return list.remove(index);
    }

    public synchronized boolean remove(String string){
        return list.remove(string);
    }

    public synchronized int size(){

        return list.size();
    }




}

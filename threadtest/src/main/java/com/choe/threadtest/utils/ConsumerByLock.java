package com.choe.threadtest.utils;

/**
 * @author cyk
 * @date 2018/7/24/024 10:11
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ConsumerByLock {



    private StoreByLock store;

    public ConsumerByLock( StoreByLock store) {
        this.store = store;
    }

    public void consume(){

        store.consume();
    }
}

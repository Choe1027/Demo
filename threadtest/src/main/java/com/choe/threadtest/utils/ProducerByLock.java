package com.choe.threadtest.utils;

/**
 * @author cyk
 * @date 2018/7/24/024 10:25
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ProducerByLock {

    private StoreByLock store;

    public ProducerByLock( StoreByLock store) {
        this.store = store;
    }

    public void produce(){

        store.produce();
    }
}

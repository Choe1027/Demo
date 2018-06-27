package com.choe.basis.domain;

import java.util.concurrent.CountDownLatch;

/**
 * @author cyk
 * @date 2018/6/25/025 16:24
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class XCountDownLatch {

    private CountDownLatch countDownLatch;


    public XCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}

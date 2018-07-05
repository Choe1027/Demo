package com.choe.applicationevent.domain;

import java.util.List;

/**
 * @author cyk
 * @date 2018/7/5/005 14:07
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class OrderBean {

    private int totalMoney;
    private List<String> goods;


    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public List<String> getGoods() {
        return goods;
    }

    public void setGoods(List<String> goods) {
        this.goods = goods;
    }
}

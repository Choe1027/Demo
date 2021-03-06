package com.choe.springboottest.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author cyk
 * @date 2018/7/12/012 17:36
 * @email choe0227@163.com
 * @desc  通过JPA的方式来操作数据库
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Entity
@Table(name = "student")
//@Proxy(lazy = false)
public class JPAStudent extends JPABaseBean{

    @Column
    private Integer height;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


}

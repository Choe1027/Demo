package com.choe.springboottest.jpa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author cyk
 * @date 2018/9/6/006 16:06
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@MappedSuperclass
public class JPABizBean  {

    /**
     * 主键生成策略
     * - TABLE：使用一个特定的数据库表格来保存主键。
     * - SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
     * - IDENTITY：主键由数据库自动生成（主要是自动增长型）
     * - AUTO：主键由程序控制(也是默认的,在指定主键时，如果不指定主键生成策略，默认为AUTO
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.choe.springboottest.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class JPAStudent {

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

    @Column(name = "name")
    private String studentName;

    @Column
    private Integer height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "JPAStudent{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", height=" + height +
                '}';
    }
}

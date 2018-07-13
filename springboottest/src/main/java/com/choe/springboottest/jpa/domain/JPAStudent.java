package com.choe.springboottest.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String student_name;

    private Integer height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}

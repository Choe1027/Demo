package com.choe.springboottest.jpa.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author cyk
 * @date 2018/9/6/006 15:54
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@MappedSuperclass
public class JPABaseBean extends JPABizBean{

    @Column(name = "name")
    private String studentName;


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}

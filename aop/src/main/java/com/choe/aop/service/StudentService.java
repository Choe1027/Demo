package com.choe.aop.service;


import com.choe.common.domain.Student;

/**
 * @author cyk
 * @date 2018/6/19/019 14:32
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface StudentService {


    void pringStudentName(Student student);

    Student add(Student student);

    Integer delete(Student student);
}

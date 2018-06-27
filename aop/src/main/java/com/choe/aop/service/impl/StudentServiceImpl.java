package com.choe.aop.service.impl;


import com.choe.aop.service.StudentService;
import com.choe.common.domain.Student;

import org.springframework.stereotype.Service;

/**
 * @author cyk
 * @date 2018/6/19/019 14:34
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public void pringStudentName(Student student) {
        System.out.println(student.getName());
    }

    @Override
    public Student add(Student student) {
        System.out.println("添加student");
        student.setId(111L);
        return student;
    }

    @Override
    public Integer delete(Student student) {
        System.out.println("delete student");
        return 0;
    }
}

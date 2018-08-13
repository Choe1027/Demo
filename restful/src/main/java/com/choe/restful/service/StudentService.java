package com.choe.restful.service;

import com.choe.common.domain.Student;

import java.util.List;

/**
 * @author cyk
 * @date 2018/8/13/013 09:47
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface StudentService {


    Student getInfoById(Long id);
    List<Student> getList();
    Student updateInfoById(Long id ,Student student);
    Student add(Student student);
    void delete(Long id);
}

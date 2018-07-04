package com.choe.mysql.service;

import com.choe.common.domain.Student;

/**
 * @author cyk
 * @date 2018/6/20/020 17:50
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface StudentService {

    Student add(Student student);

    Student update(Student student);


    Student addByEasy();
}

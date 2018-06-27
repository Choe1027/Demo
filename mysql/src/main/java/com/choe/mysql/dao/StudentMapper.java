package com.choe.mysql.dao;

import com.choe.common.domain.Student;

import org.springframework.stereotype.Repository;

/**
 * @author cyk
 * @date 2018/6/20/020 16:55
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Repository
public interface StudentMapper {

    void add(Student student);

    void update(Student student);
}

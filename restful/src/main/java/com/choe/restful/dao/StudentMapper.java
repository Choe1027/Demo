package com.choe.restful.dao;

import com.choe.common.domain.Student;

import org.springframework.stereotype.Repository;

import java.util.List;

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

    void delete(Long id);

    List<Student> getList();

    Student getById(Long id);
}

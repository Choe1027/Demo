package com.choe.restful.service;

import com.choe.common.domain.Student;
import com.choe.restful.dao.StudentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cyk
 * @date 2018/8/13/013 09:50
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getInfoById(Long id) {
        return studentMapper.getById(id);
    }

    @Override
    public List<Student> getList() {
        return studentMapper.getList();
    }

    @Override
    public Student updateInfoById(Long id, Student student) {
        student.setId(id);
        studentMapper.update(student);
        return student;
    }

    @Override
    public Student add(Student student) {
        studentMapper.add(student);
        return student;
    }

    @Override
    public void delete(Long id) {
        studentMapper.delete(id);
    }
}

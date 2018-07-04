package com.choe.mysql.service.impl;

import com.choe.common.domain.Student;
import com.choe.mysql.dao.StudentMapper;
import com.choe.mysql.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author cyk
 * @date 2018/6/20/020 17:50
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
@Transactional
/**
 * 测试事务
 */
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student add(Student student) {
        studentMapper.add(student);
        if (!StringUtils.isEmpty(student.getId())){
            student.setName("update name");
            int a = 1/0;
            studentMapper.update(student);
        }
        return student;
    }

    @Override
    public Student update(Student student) {
        return null;
    }


    @Override
    public Student addByEasy() {
        return null;
    }
}

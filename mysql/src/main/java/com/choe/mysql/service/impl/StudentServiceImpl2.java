package com.choe.mysql.service.impl;

import com.choe.mysql.domain.Student2;
import com.choe.mysql.service.StudentService2;
import com.example.shyFly.easySql.EasySqlExecution;
import com.example.shyFly.easySql.bean.EasySqlResult;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.PostConstruct;

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
public class StudentServiceImpl2 implements StudentService2 {

//    @Autowired
    private EasySqlExecution easySqlExecution;

    @PostConstruct
    public void init(){
        easySqlExecution = new EasySqlExecution();

    }
    @Override
    public Student2 addByEasy(Student2 student2) {
        return easySqlExecution.add(student2);
    }

    @Override
    public Integer deleteByEasy(Student2 student2) {
       return easySqlExecution.delete(student2);
    }

    @Override
    public List<Student2> selectByEasy(Student2 student2) {

        return easySqlExecution.select(student2);
    }

    @Override
    public EasySqlResult<Student2> listPage(Student2 student2, Integer currentPage, Integer showCount) {
        EasySqlResult<Student2> student2EasySqlResult = easySqlExecution.listPage(student2, currentPage, showCount);
        return student2EasySqlResult;
    }

    @Override
    public Integer updateByEasy(Student2 student2) {
        return easySqlExecution.update(student2);
    }


}

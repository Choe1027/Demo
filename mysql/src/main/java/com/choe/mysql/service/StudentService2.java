package com.choe.mysql.service;

import com.choe.mysql.domain.Student2;
import com.example.shyFly.easySql.bean.EasySqlResult;

import java.util.List;

/**
 * @author cyk
 * @date 2018/6/20/020 17:50
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface StudentService2 {

    Student2 addByEasy(Student2 student2);

    Integer deleteByEasy(Student2 student2);

    List<Student2>  selectByEasy(Student2 student2);


    Integer updateByEasy(Student2 student2);

    EasySqlResult<Student2> listPage(Student2 student2, Integer currentPage, Integer showCount);
}

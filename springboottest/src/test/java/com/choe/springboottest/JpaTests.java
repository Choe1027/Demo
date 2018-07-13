package com.choe.springboottest;

import com.choe.springboottest.jpa.domain.JPAStudent;
import com.choe.springboottest.jpa.repositorys.JpaStudentRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cyk
 * @date 2018/7/13/013 11:38
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTests {

    @Autowired
    private JpaStudentRepository jpaStudentRepository;

    @Test
    public void testDefaultQuery(){

        long count = jpaStudentRepository.count();
        System.out.println("所有记录"+count);
        Long id = 12L;
        boolean isExist = jpaStudentRepository.existsById(id);
        System.out.println("表中是否存在"+id+":"+isExist);
        Long id2 = 11L;
        JPAStudent one = jpaStudentRepository.getOne(id2);
        System.out.println("student_name=="+one.getStudent_name() +" height=="+one.getHeight()+" id==="+one.getId());
    }


    public void testDefaultComplex(){
//
//        JPAStudent jpaStudent = new JPAStudent();
//        Example example = Example.create(jpaStudent);
//        example.
    }

}

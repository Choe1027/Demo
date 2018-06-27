package com.choe.aop;

import com.choe.aop.service.StudentService;
import com.choe.common.domain.Student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

    @Autowired
    private StudentService studentService;


    @Test
    public void contextLoads() {
    }


    @Test
    // 测试环绕通知
    public void testAround(){
        Student student = new Student();
        student.setName("先行、");
        studentService.add(student);
    }
}

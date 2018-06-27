package com.choe.aop.ctrl;


import com.choe.aop.aop.StudentAop;
import com.choe.aop.service.StudentService;
import com.choe.common.domain.Student;
import com.choe.common.utils.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyk
 * @date 2018/6/19/019 19:14
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/test")
    public void testStudent(HttpServletRequest request, HttpServletResponse response, Integer call){

        switch (call){

            // 添加学生
            case 101 :
            {
                Student student = new Student();
                studentService.add(student);
                StudentAop.resultPool.set(JsonUtil.objToJson(student));
                break;
            }
            // 删除学生
            case 102 :
            {
                Student student = new Student();
                studentService.delete(student);
                break;
            }

        }


    }


}

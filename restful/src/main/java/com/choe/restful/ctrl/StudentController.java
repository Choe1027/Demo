package com.choe.restful.ctrl;

import com.choe.common.domain.Student;
import com.choe.restful.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cyk
 * @date 2018/8/13/013 09:44
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public Student getInfoById(@PathVariable("id") Long studentId){
        return studentService.getInfoById(studentId);
    }
    @RequestMapping(method = {RequestMethod.GET})
    public Object getList(){
        List<Student> list = studentService.getList();
        System.out.println("sssss");
        return list;
    }
    @RequestMapping(value = "/{id}",method = {RequestMethod.PUT})
    public Student updateInfoById(@PathVariable("id") Long studentId, @RequestBody Student student){

        return studentService.updateInfoById(studentId,student);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public Student addStudent(@RequestBody Student student){
        return studentService.add(student);
    }
    @RequestMapping(value = "{id}",method = {RequestMethod.DELETE})
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.delete(id);
    }
}

package com.choe.springboottest;

import com.choe.springboottest.jpa.domain.JPAStudent;
import com.choe.springboottest.jpa.repositorys.JpaStudentRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

        // 计数
        long count = jpaStudentRepository.count();
        System.out.println("所有记录"+count);
        // 检验是否存在
        Long id = 12L;
        boolean isExist = jpaStudentRepository.existsById(id);
        System.out.println("表中是否存在"+id+":"+isExist);
        Long id2 = 3L;
        // 获取一个 根据id
        JPAStudent one = jpaStudentRepository.getOne(id2);
        System.out.println("student_name=="+one.getStudentName() +" height=="+one.getHeight()+" id==="+one.getId());

        //Example 类似hibernate 逆向工程生成的
        //TODO
        JPAStudent jpaStudent = new JPAStudent();
        jpaStudent.setId(1L);

        // 获取全部
        List<JPAStudent> all = jpaStudentRepository.findAll();
        System.out.println("all==="+all.toString());
        //查询全部 排序
        List<JPAStudent> orderByIdAll = jpaStudentRepository.findAll(Sort.by(Sort.Order.desc("id")));
        System.out.println("orderByIdAll==="+orderByIdAll.toString());
        // 分页查询
        Page<JPAStudent> pageAll = jpaStudentRepository.findAll(new PageRequest(0, 1));
        System.out.println("totalPage==="+pageAll.getTotalPages()+ "列表=="+pageAll.getContent());

    }



    @Test
    public void testDefaultAdd(){

        // save 方法 需要手动指定id
        JPAStudent jpaStudent = new JPAStudent();
        jpaStudent.setHeight(4444);
        jpaStudent.setStudentName("jpa");
        JPAStudent save = jpaStudentRepository.save(jpaStudent);
        System.out.println("save"+save);

        JPAStudent jpaStudent1 = new JPAStudent();
        jpaStudent1.setHeight(1);
        jpaStudent1.setStudentName("jpa");
        JPAStudent jpaStudent2 = new JPAStudent();
        jpaStudent2.setHeight(2);
        jpaStudent2.setStudentName("jpa2");
        List<JPAStudent> jpaStudents = new ArrayList<>();
        jpaStudents.add(jpaStudent1);
        jpaStudents.add(jpaStudent2);
        jpaStudentRepository.saveAll(jpaStudents);
        JPAStudent jpaStudent3 = new JPAStudent();
        jpaStudent3.setHeight(3);
        jpaStudent3.setStudentName("jpa3");
        JPAStudent jpaStudent4 = jpaStudentRepository.saveAndFlush(jpaStudent3);
        System.out.println(jpaStudent4);
    }

    @Test
    public void testDefaultUpdate(){
        // 更新方法即保存，根据id
        JPAStudent one = jpaStudentRepository.getOne(1L);
        one.setStudentName("jpaUpdate");
        jpaStudentRepository.save(one);

    }

    @Test
    public void testDefaultDelete(){
        // 需要根据id来删除
        JPAStudent jpaStudent = new JPAStudent();
        jpaStudent.setId(1L);
        jpaStudent.setStudentName("jpa");
        jpaStudentRepository.delete(jpaStudent);

    }

    @Test
    public void testDefinite(){
        // 查询
        List<JPAStudent> jpa = jpaStudentRepository.findByStudentName("jpa");
        System.out.println("jpa==="+jpa);
        List<JPAStudent> jpaLike = jpaStudentRepository.findByStudentNameLike("%jpa%");
        System.out.println("jpaLike==="+jpaLike);

    }
}

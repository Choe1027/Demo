package com.choe.mysql;

import com.choe.mysql.domain.Student2;
import com.choe.mysql.service.StudentService2;
import com.example.shyFly.easySql.EasySqlExecution;
import com.example.shyFly.easySql.bean.EasySqlResult;
import com.example.shyFly.easySql.bean.OperMark;
import com.example.shyFly.easySql.bean.SpliceBean;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasySqlTest {

    @Autowired
    private StudentService2 studentService2;

//    @Autowired
    private EasySqlExecution easySqlExecution;

    @Before
    public void init(){
        easySqlExecution = new EasySqlExecution();
    }

    @Test
    public void testAdd(){
        Student2 student2 = new Student2();
        student2.setName("easySql");
        student2.setHeight(188);
        studentService2.addByEasy(student2);
    }

    @Test
    public void testSelect(){
        Student2 student2 = new Student2();
        List<Student2> student2s = studentService2.selectByEasy(student2);
        System.out.println(student2s);
    }

    @Test
    public void testListPage(){
        Student2 student2 = new Student2();
        EasySqlResult<Student2> result = studentService2.listPage(student2, 2, 2);
        System.out.println(result);
    }
    @Test
    public void testUpdate(){
        Student2 student2 = new Student2();
        student2.setId(2L);
        student2.setName("hhhh");
        studentService2.updateByEasy(student2);
    }
    @Test
    public void testdelete(){
        Student2 student2 = new Student2();
        student2.setId(1L);
        studentService2.deleteByEasy(student2);
    }

    @Test
    public void testSelect2(){
        Student2 student2 = new Student2();
        student2.setName("easysql");
        List<Student2> student2s = studentService2.selectByEasy(student2);
        System.out.println(student2s);
    }

    @Test
    // 测试聚合
    public void testSelectBy(){
        Student2 student2 = new Student2();
//        easySqlExecution.listPage(student2,)
        // 测试like
        SpliceBean spliceBean = new SpliceBean("name",OperMark.like,"easy");
        List<Student2> select = easySqlExecution.select(student2, spliceBean);
        // 测试gte
        SpliceBean spliceBean2 = new SpliceBean("height",OperMark.gte,100);
        List<Student2> select2 = easySqlExecution.select(student2, spliceBean2);

        // 测试lte
        SpliceBean spliceBean3 = new SpliceBean("height",OperMark.lte,100);
        List<Student2> select3 = easySqlExecution.select(student2, spliceBean3);
        // 测试not in
        SpliceBean spliceBean4 = new SpliceBean("id",OperMark.notIn,3);
        List<Student2> select4 = easySqlExecution.select(student2, spliceBean4);

        System.out.println(select);
    }

    @Test
    // 测试分页+ 聚合
    public void testListPageBy(){
        Student2 student2 = new Student2();
        // 测试like + desc
        SpliceBean spliceBean = new SpliceBean("name",OperMark.like,"easy");
        EasySqlResult<Student2> result = easySqlExecution.listPage(student2, 1, 3, "id", true, spliceBean);
        // 测试gte  + desc
        SpliceBean spliceBean2 = new SpliceBean("height",OperMark.gte,100);
        EasySqlResult<Student2> result2 = easySqlExecution.listPage(student2, 1, 3, "id", true, spliceBean2);

        // 测试lte  + desc
        SpliceBean spliceBean3 = new SpliceBean("height",OperMark.lte,100);
        EasySqlResult<Student2> result3 = easySqlExecution.listPage(student2, 1, 3, "id", true, spliceBean3);

        // 测试not in +desc
        SpliceBean spliceBean4 = new SpliceBean("id",OperMark.notIn,6);
        EasySqlResult<Student2> result4 = easySqlExecution.listPage(student2, 1, 3, "id", true, spliceBean4);

        System.out.println(result);
    }

    @Test
    public void testManyBy(){
        Student2 student2 = new Student2();
//        easySqlExecution.listPage(student2,)
        // 测试like
        SpliceBean spliceBean = new SpliceBean("name",OperMark.like,"easy");
        SpliceBean spliceBean1 = new SpliceBean("height",OperMark.gte,100);
        List<Student2> select = easySqlExecution.select(student2, spliceBean,spliceBean1);
        System.out.println(select);
    }
}

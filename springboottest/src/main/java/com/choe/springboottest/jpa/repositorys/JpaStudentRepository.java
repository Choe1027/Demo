package com.choe.springboottest.jpa.repositorys;

import com.choe.springboottest.jpa.domain.JPAStudent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author cyk
 * @date 2018/7/12/012 17:40
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface JpaStudentRepository extends JpaRepository<JPAStudent,Long> {

    /*
     * 关于查询名称的定义需要符合规范才能够被编译
     * findBy 、 read 、find、readBy、query 、queryBy、get、 getBy 开头
     * 属性名称必须与实体中的名称对应上，否则编译不通过
     * 多个条件组合，需要根据规范来连接。 And Or Like  详情查看
     */

    List<JPAStudent> findByStudentName(String name);

    List<JPAStudent> findByStudentNameLike(String name);

}
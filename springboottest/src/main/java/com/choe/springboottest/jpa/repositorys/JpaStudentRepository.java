package com.choe.springboottest.jpa.repositorys;

import com.choe.springboottest.jpa.domain.JPAStudent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
public interface JpaStudentRepository extends JpaRepository<JPAStudent,Long> , JpaSpecificationExecutor<JPAStudent> {

    /*
     * 关于查询名称的定义需要符合规范才能够被编译
     * findBy 、 read 、find、readBy、query 、queryBy、get、 getBy 开头
     * 属性名称必须与实体中的名称对应上，否则编译不通过
     * 多个条件组合，需要根据规范来连接。 And Or Like  详情查看
     */

    List<JPAStudent> findByStudentName(String name);

    List<JPAStudent> findByStudentNameLike(String name);

    List<JPAStudent> findByHeightIsNull();

    List<JPAStudent> findTopByStudentName(String name);

    List<JPAStudent> findByHeightBetween(int gte, int lte);

    @Query("select jpa from JPAStudent jpa where jpa.studentName = :studentName order by id desc")
    List<JPAStudent> getAllStudentOrderByIdDesc(@Param("studentName") String name);

    @Query("select jpa from JPAStudent jpa where jpa.studentName = ?1 order by id desc")
    List<JPAStudent> getAllStudent( String name);

}
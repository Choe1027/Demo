package com.choe.springboottest.jpa.repositorys;

import com.choe.springboottest.jpa.domain.JPAStudent;

import org.springframework.data.jpa.repository.JpaRepository;

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

}

package com.choe.mysql.dao;

import com.choe.common.domain.NewOrderBean;

import org.springframework.stereotype.Repository;

/**
 * @author cyk
 * @date 2018/6/25/025 11:31
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Repository
public interface NewOrderMapper {

    void add(NewOrderBean bean);
}

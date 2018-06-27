package com.choe.mysql.dao;

import com.choe.common.domain.OldOrderBean;

import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface OldOrderMapper {

    List<OldOrderBean> select(OldOrderBean bean);
}

package com.choe.mysql.dao;

import com.choe.common.domain.CityBean;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cyk
 * @date 2018/6/22/022 16:49
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Repository
public interface CityMapper {

    List<CityBean> select(CityBean cityBean);
}

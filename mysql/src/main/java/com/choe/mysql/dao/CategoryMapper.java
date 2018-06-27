package com.choe.mysql.dao;

import com.choe.common.domain.CategoryBean;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cyk
 * @date 2018/6/21/021 16:34
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Repository
public interface CategoryMapper {

    List<CategoryBean>  getCategoryList(CategoryBean bean);
}

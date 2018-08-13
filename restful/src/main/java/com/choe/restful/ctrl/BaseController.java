package com.choe.restful.ctrl;

import java.util.List;

/**
 * @author cyk
 * @date 2018/8/13/013 11:22
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface BaseController<T ,V extends T> {

    T add(T t);

    T updateById(Long id,V v);

    T getById(Long id);

    List<T> getList();

    void deleteById(Long id);

}

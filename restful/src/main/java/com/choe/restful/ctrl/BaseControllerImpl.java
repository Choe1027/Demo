package com.choe.restful.ctrl;

import java.util.List;

/**
 * @author cyk
 * @date 2018/8/13/013 11:50
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class BaseControllerImpl<T,V extends T> implements BaseController<T,V > {
    @Override
    public T add(T t) {
        return null;
    }

    @Override
    public T updateById(Long id, V v) {
        return null;
    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public List<T> getList() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}

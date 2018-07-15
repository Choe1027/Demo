package com.choe.springboottest.jpa.repositorys;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

public interface CustomRepository<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID> {

    /**
     * 根据对象中的条件获取值,不一定需要id
     * @param t
     * @return
     */
    T get(T t);

    /**
     * 根据对象中的条件查询所有
     * @param t
     * @return
     */
    List<T> findAll(T t);

    /**
     * 根据条件进行获取总的条数
     * @param t
     * @return
     */
    Integer count(T t);

    /**
     * 批量更新,可以不包含id
     * @param t
     */
    void updateInBatch(T t);

    /**
     * 根据其他条件来删除，不仅仅是id
     * @param t
     */
    void deleteByOther(T t);
}

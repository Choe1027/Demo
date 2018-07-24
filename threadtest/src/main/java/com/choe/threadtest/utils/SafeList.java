package com.choe.threadtest.utils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author cyk
 * @date 2018/7/24/024 09:57
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class SafeList<T> extends ArrayList<T> {

    public SafeList(int initialCapacity) {
        super(initialCapacity);
    }

    public SafeList() {
        super();
    }

    public SafeList(Collection<? extends T> c) {
        super(c);
    }

    @Override
    public int size() {
        synchronized (this){
            return super.size();
        }
    }

    @Override
    public T get(int index) {
        synchronized (this){
            return super.get(index);
        }
    }

    @Override
    public T set(int index, T element) {
        synchronized (this){
            return super.set(index, element);
        }
    }

    @Override
    public boolean add(T t) {
        synchronized (this){
            return super.add(t);
        }
    }

    @Override
    public void add(int index, T element) {
       synchronized (this){
           super.add(index, element);
       }
    }

    @Override
    public T remove(int index) {
        synchronized (this){
            return super.remove(index);
        }
    }

    @Override
    public boolean remove(Object o) {
       synchronized (this){
           return super.remove(o);
       }
    }

    @Override
    public void clear() {
       synchronized (this){
           super.clear();
       }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        synchronized (this){
            return super.addAll(c);
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        synchronized (this){
            return super.addAll(index, c);
        }
    }
}

package com.choe.designmodel.factory.factorymethod;

import com.choe.designmodel.factory.domain.Role;

/**
 * @author cyk
 * @date 2018/7/26/026 11:23
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface RoleFactory {
    Role create(Integer sex);
}

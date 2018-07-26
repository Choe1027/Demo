package com.choe.designmodel.factory.simplefactory;

import com.choe.designmodel.factory.domain.Role;

/**
 * @author cyk
 * @date 2018/7/25/025 17:25
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface RoleCreator {

    Role create(Role role);
}

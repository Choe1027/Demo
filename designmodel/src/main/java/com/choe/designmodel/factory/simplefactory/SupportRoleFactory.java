package com.choe.designmodel.factory.simplefactory;

import com.choe.designmodel.factory.domain.Role;
import com.choe.designmodel.factory.domain.SupportRole;

/**
 * @author cyk
 * @date 2018/7/25/025 17:34
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class SupportRoleFactory implements RoleFactory {

    @Override
    public Role create(Role role) {
        SupportRole supportRole = new SupportRole();
        supportRole.setName(role.getName());
        supportRole.setSex(role.getSex());
        supportRole.setType(role.getType());
        return supportRole;
    }
}

package com.choe.designmodel.factory.simplefactory;

import com.choe.designmodel.factory.domain.Role;
import com.choe.designmodel.factory.domain.TankRole;

/**
 * @author cyk
 * @date 2018/7/25/025 17:34
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class TankRoleCreator implements RoleCreator {
    @Override
    public Role create(Role role) {
        TankRole tankRole = new TankRole();
        tankRole.setName(role.getName());
        tankRole.setSex(role.getSex());
        tankRole.setType(role.getType());
        return tankRole;
    }
}

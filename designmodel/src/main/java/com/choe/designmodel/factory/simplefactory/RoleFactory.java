package com.choe.designmodel.factory.simplefactory;

import com.choe.designmodel.factory.domain.Role;

/**
 * @author cyk
 * @date 2018/7/25/025 17:38
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class RoleFactory {

    public static Role factory(Role role){

        if (role.getType() == Role.RoleType.TANK){
            return new TankRoleCreator().create(role);
        }else if(role.getType() == Role.RoleType.SUPPORT){
            return new SupportRoleCreator().create(role);
        }else {
            throw new IllegalArgumentException("位置的角色类型");
        }
    }
}

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
public class RoleManger {

    public static RoleFactory factory(Role role){

        if (role.getType() == Role.RoleType.TANK){
            return new TankRoleFactory();
        }else if(role.getType() == Role.RoleType.SUPPORT){
            return new SupportRoleFactory();
        }else {
            throw new IllegalArgumentException("位置的角色类型");
        }
    }
}

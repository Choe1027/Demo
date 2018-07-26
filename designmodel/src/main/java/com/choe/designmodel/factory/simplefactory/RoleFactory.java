package com.choe.designmodel.factory.simplefactory;

import com.choe.designmodel.factory.domain.Role;
import com.choe.designmodel.factory.domain.SupportRole;
import com.choe.designmodel.factory.domain.TankRole;

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

    public static Role create(Role.RoleType roleType){

        if (roleType == Role.RoleType.TANK){
            return new TankRole();
        }else if(roleType == Role.RoleType.SUPPORT){
            return new SupportRole();
        }else {
            throw new IllegalArgumentException("位置的角色类型");
        }
    }
}

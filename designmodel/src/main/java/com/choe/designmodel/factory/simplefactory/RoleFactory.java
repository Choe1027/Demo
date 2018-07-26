package com.choe.designmodel.factory.simplefactory;

import com.choe.designmodel.factory.domain.FemaleMageRole;
import com.choe.designmodel.factory.domain.MaleSwordManRole;
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

    public static Role create(Role.RoleType roleType){

        if (roleType == Role.RoleType.SWORDSMAN){
            return new MaleSwordManRole();
        }else if(roleType == Role.RoleType.MAGE){
            return new FemaleMageRole();
        }else {
            throw new IllegalArgumentException("未知的角色类型");
        }
    }
}

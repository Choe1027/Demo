package com.choe.designmodel.factory.factorymethod;

import com.choe.designmodel.factory.domain.Role;

/**
 * @author cyk
 * @date 2018/7/26/026 11:33
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class FactoryManage {

    public static  RoleFactory factory(Role.RoleType roleType){

        if (roleType ==Role.RoleType.SWORDSMAN){

            return new SwordRoleFactory();
        }else if (roleType ==Role.RoleType.MAGE){

            return new MageRoleFactory();
        }else {
            throw new IllegalArgumentException("未知的角色类别");
        }
    }
}

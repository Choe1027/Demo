package com.choe.designmodel.factory.factorymethod;

import com.choe.designmodel.factory.domain.Role;

/**
 * @author cyk
 * @date 2018/7/26/026 11:32
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class FactoryMethodTests {

    public static void main(String[] args) {

        RoleFactory roleFactory = FactoryManage.factory(Role.RoleType.SWORDSMAN);
        Role role = roleFactory.create(0);
        System.out.println(role);
    }
}

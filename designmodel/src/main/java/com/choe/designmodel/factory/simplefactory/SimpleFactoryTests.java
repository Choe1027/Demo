package com.choe.designmodel.factory.simplefactory;

import com.choe.designmodel.factory.domain.Role;

/**
 * @author cyk
 * @date 2018/7/25/025 17:44
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class SimpleFactoryTests {


    public static void main(String[] args) {

        Role role = new Role();
        role.setName("深海泰坦");
        role.setSex(0);
        role.setType(Role.RoleType.TANK);

        RoleFactory factory = RoleManger.factory(role);
        Role createRole = factory.create(role);
        System.out.println(createRole.toString());
    }
}

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

        // 模仿调用接口的请求参数
        Role role = new Role();
        role.setName("深海泰坦");
        role.setSex(0);
        role.setType(Role.RoleType.TANK);

        // 逻辑处理
        Role createRole  = RoleFactory.factory(role);
        System.out.println(createRole.toString());
    }
}

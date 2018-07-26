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

        // 逻辑处理
        Role createRole  = RoleFactory.create(Role.RoleType.TANK);
        System.out.println(createRole.toString());
    }
}

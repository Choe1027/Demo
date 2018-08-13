package com.choe.designmodel.factory.factorymethod;

import com.choe.designmodel.factory.domain.FemaleSwordManRole;
import com.choe.designmodel.factory.domain.MaleSwordManRole;
import com.choe.designmodel.factory.domain.Role;

/**
 * @author cyk
 * @date 2018/7/26/026 11:26
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class SwordRoleFactory implements RoleFactory {

    @Override
    public Role create(Integer sex) {
        if (sex != null && sex.equals(0)){
            return new MaleSwordManRole();
        }else if (sex != null && sex.equals(1)){
            return new FemaleSwordManRole();
        }else {
            throw new IllegalArgumentException("未知的性别");
        }
    }
}

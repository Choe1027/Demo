package com.choe.designmodel.factory.factorymethod;

import com.choe.designmodel.factory.domain.FemaleMageRole;
import com.choe.designmodel.factory.domain.MaleMageRole;
import com.choe.designmodel.factory.domain.Role;

/**
 * @author cyk
 * @date 2018/7/26/026 11:30
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class MageRoleFactory implements RoleFactory{
    @Override
    public Role create(Integer sex) {
        if (sex != null && sex.equals(0)){
            return new MaleMageRole();
        }else if (sex != null && sex.equals(1)){
            return new FemaleMageRole();
        }else {
            throw new IllegalArgumentException("未知的性别");
        }
    }
}

package com.choe.designmodel.factory.domain;

import java.io.Serializable;

/**
 * @author cyk
 * @date 2018/7/25/025 17:25
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Role implements Serializable {

    private String name;
    private Integer sex;
    private RoleType type;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", type=" + type +
                ", desc='" + desc + '\'' +
                '}';
    }

    public enum RoleType{
        SWORDSMAN(0,"鬼剑士"),
        HOLYPRIEST(1,"圣职者"),
        DARKWARRIOR(2,"黑暗武士"),
        SHARPSHOOTER(3,"神枪手"),
        MAGE(4,"法师");
        private int typeCode;
        private String name;

        RoleType(int typeCode, String name) {
            this.typeCode = typeCode;
            this.name = name;
        }
    }


}

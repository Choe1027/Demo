package com.choe.easysql.dommain;

import com.example.shyFly.easySql.annotations.TableField;
import com.example.shyFly.easySql.annotations.TableId;
import com.example.shyFly.easySql.annotations.TableName;

import java.io.Serializable;

/**
 * @author cyk
 * @date 2018/6/19/019 14:32
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@TableName(name="student")
public class Student2 implements Serializable {

    @TableId
    private Long id;
    @TableField(name = "name")
    private String name;
    @TableField(name = "height")
    private Integer height;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}

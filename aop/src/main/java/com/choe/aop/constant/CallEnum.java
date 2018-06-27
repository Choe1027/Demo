package com.choe.aop.constant;

/**
 * @author cyk
 * @date 2018/6/20/020 14:23
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public enum CallEnum {
    _101(101,"添加学生"),
    _102(102,"删除学生")
    ;

    private Integer code;
    private String remark;

    private CallEnum(Integer code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static String forCode(Integer code){

        for(CallEnum call : CallEnum.values()){

            if (code.equals(call.getCode())){
                return call.getRemark();
            }
        }

        return "";
    }

}

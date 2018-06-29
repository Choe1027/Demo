package com.choe.poiutils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cyk
 * @date 2018/6/29/029 17:51
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelFiled {
    /**表格列名*/
    String colName() default "";
    /**列宽度*/
    int colWidth() default 4000;
    /**列序号*/
    int colIndex() default 1;
}

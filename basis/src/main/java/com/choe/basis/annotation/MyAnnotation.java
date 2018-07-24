package com.choe.basis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cyk
 * @date 2018/7/24/024 16:56
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyAnnotation {

    // 指定一个类型值，类型可以切换成其他的基本类型
    int init() default 0;

    // 枚举类型的值
    MyColor color() default MyColor.BLACK;

    // 数组类型
    MyColor[] colors() default {MyColor.BLACK};

    //还可以是注解
    XAnnotation xAnnotation() default @XAnnotation("lonikie");


    /*

        注解说明：
            Retention 注解，表示注解所在的生命周期，
                 RetentionPolicy.SOURCE     源码级别的注解，只存在于.java 文件中，如@override注解上的就是这个类型
                 RetentionPolicy.CLASS      编译成class文件的时候，会存在于.class 文件中
                 RetentionPolicy.RUNTIME    当虚拟机将class文件转换成字节码时，会存在于内存的字节码中

            Target 注解,用来标志注解的作用范围
                 ElementType.TYPE           标志为该注解使用在类级别的，如类，接口，枚举，注解
                 ElementType.FIELD          标志为该注解使用在属性上
                 ElementType.METHOD         标志为该注解使用在方法上
                 ElementType.PARAMETER      标志为该注解使用在参数上
                 ElementType.CONSTRUCTOR    标志为该注解使用在构造函数上
                 ElementType.LOCAL_VARIABLE 标志为该注解使用在本地变量上
                 ElementType.ANNOTATION_TYPE标志为该注解使用在注解上
                 ElementType.PACKAGE        标志为该注解使用在包上
                 ElementType.TYPE_PARAMETER 1.8之后才有 标志为参数类型
                 ElementType.TYPE_USE       1.8之后才有 类型// 暂时不明白
            Documented 注解，并无实际意义，只是用来通过在javadoc输出文档的时候，将被这个注解所修饰的注解作为文档内容输出
            Inherited  注解, 表示子类可以继承父类的注解

     *
     */


    // 定义注解属性

    enum MyColor{
        RED,
        YELLOW,
        BLACK
    }
}

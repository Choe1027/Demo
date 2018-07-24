package com.choe.basis.annotation;

import java.lang.annotation.Annotation;

/**
 * @author cyk
 * @date 2018/7/24/024 17:10
 * @email choe0227@163.com
 * @desc  操作注解相关api
 * @modifier
 * @modify_time
 * @modify_remark
 */
@MyAnnotation(init = 2,color = MyAnnotation.MyColor.RED,colors = {MyAnnotation.MyColor.BLACK,MyAnnotation.MyColor.YELLOW},xAnnotation = @XAnnotation("choe and lonikie"))
public class AnnotationTest {

    public static void main(String[] args) {
        // 查看当前类是否有某个注解
        boolean annotationPresent = AnnotationTest.class.isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent){
            System.out.println("包含MyAnnotation 注解");
            // 获取某个注解
            MyAnnotation annotation = AnnotationTest.class.getAnnotation(MyAnnotation.class);
            // 获取注解中的值
            MyAnnotation.MyColor color = annotation.color();
            MyAnnotation.MyColor[] colors = annotation.colors();
            int init = annotation.init();
            XAnnotation xAnnotation = annotation.xAnnotation();
            String value = xAnnotation.value();
            System.out.println();
        }

        // 获取类中所有的注解
        Annotation[] annotations = AnnotationTest.class.getAnnotations();
    }
}

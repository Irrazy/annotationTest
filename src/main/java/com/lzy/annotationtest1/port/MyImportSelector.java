package com.lzy.annotationtest1.port;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @program: annotationtest1
 * @description: 自定义导入选择器
 * @author: 作者
 * @create: 2021-11-25 17:32
 */
public class MyImportSelector implements ImportSelector {

    // param: importingClassMetadata--- 加了@Import注解的类上面的所有注解信息

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //获取当前类的所有注解
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        System.out.println("当前配置类的注解信息是"+annotationTypes);
        System.out.println("注册com.lzy.annotationtest1.pojo.Cat类");
        return new String[]{"com.lzy.annotationtest1.pojo.Cat"};
        //当此方法被调用时，直接选择import此类，向调用类注入此bean
    }
}

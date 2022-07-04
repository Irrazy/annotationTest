package com.lzy.annotationtest1.port;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: annotationtest1
 * @description: 自定义导入对象注册中心
 * @author: 作者
 * @create: 2021-11-25 17:56
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    //importingMetadata:当前类的注解信息
    //registry：Bean对象注册处/器

    //importingMetadata:当前类的注解信息
    //registry：Bean对象注册处/器
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingMetadata, BeanDefinitionRegistry registry){
        /**
         * BeanDefinition可以设置组件的多个信息
         * 例如：
         * setBeanClassName 设置bean的全类名
         * setScope 设置bean的作用域
         */
          BeanDefinition beanDefinition=new RootBeanDefinition();

          //定义dog类为bean对象
          beanDefinition.setBeanClassName("com.lzy.annotationtest1.pojo.Dog");
         //设置这个bean对象的作用域
          beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
         //判断容器中是否注册Cat对象，如果有则注册Dog
        if(registry.containsBeanDefinition("com.lzy.annotationtest1.pojo.Animal")){
         //beanName为在容器中的id,把全类名设置为了id
            registry.registerBeanDefinition("Dog",beanDefinition);
        }

        System.out.println("注册了"+beanDefinition.getBeanClassName());
    }

}

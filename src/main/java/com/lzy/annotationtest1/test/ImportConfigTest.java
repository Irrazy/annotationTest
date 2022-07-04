package com.lzy.annotationtest1.test;

import com.lzy.annotationtest1.config.ImportConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: annotationtest1
 * @description: ImportConfigTest
 * @author: 作者
 * @create: 2021-11-25 16:22
 */
public class ImportConfigTest {
    //AnnotationConfigApplicationContext:注解上下文，spring中获取bean实例的又一个容器
    //通过这种方式获取配置类ImportConfig实例bean  -----手动创建bean
    AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(ImportConfig.class);


    //遍历在已创建的上下文容器中跟ImportConfig实例匹配的组件（注入bean）名称
    private void printClassName(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        //通过getBeanDefinitionNames()方法获取配置类ImportConfig实例bean中所有被定义的实例的class全名
        String[] beanDefinitionNames= annotationConfigApplicationContext.getBeanDefinitionNames();
        for(int i=0;i<beanDefinitionNames.length;i++){
            System.out.println("匹配的类名是："+beanDefinitionNames[i]);
        }
    }

    @Test
    public void ImportTest(){
        printClassName(annotationConfigApplicationContext);
    }


}

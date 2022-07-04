package com.lzy.annotationtest1.config;

import com.lzy.annotationtest1.pojo.Animal;
import com.lzy.annotationtest1.port.MyImportBeanDefinitionRegistrar;
import com.lzy.annotationtest1.port.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: annotationtest1
 * @description: ImportConfig
 * @author: 作者
 * @create: 2021-11-25 16:17
 */
@Configuration  //注解此类为配置类
@Import({Animal.class, MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
//第一次导入：测试用@Import直接导入组件---在ImportConfig类中导入普通类Animal类
//第二次导入：测试用ImportSelector接口导入组件---在ImportConfig类中导入MyImportSelector.class
//第三次导入：测试用ImportBeanDefinitionRegistrar接口导入组件---在ImportConfig类中导入MyImportBeanDefinitionRegistrar
public class ImportConfig {
}

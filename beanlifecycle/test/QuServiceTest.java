package com.study.test;
/*
* @author quchengguo
* @version 2018年4月22日 上午11:41:07
*/

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.service.QuService;

public class QuServiceTest {
	 @Test
    public void testBeanLifeCycle(){

        System.out.println("Spring容器初始化");
        System.out.println("=====================================");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

        System.out.println("Spring容器初始化完毕");
        System.out.println("=====================================");

        System.out.println("从容器中获取Bean");

        QuService service = context.getBean("quService", QuService.class);

        System.out.println("service Name="+service.getName());
        System.out.println("=====================================");

        context.close();

        System.out.println("Spring容器关闭");

    }
}

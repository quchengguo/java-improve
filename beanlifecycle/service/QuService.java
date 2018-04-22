package com.study.service;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/*
* @author quchengguo
* @version 2018年4月22日 上午11:19:29
*/
public class QuService implements  InitializingBean, DisposableBean, ApplicationContextAware, ApplicationEventPublisherAware
,BeanClassLoaderAware, BeanFactoryAware,BeanNameAware,EnvironmentAware, ImportAware, ResourceLoaderAware{
	private  String name;
	
	public QuService() {
		System.out.println("调用QuService的无参构造");
	}


	public String getName() {
		System.out.println("调用QuService中的getName方法");
		return name;
	}


	public QuService setName(String name) {
		System.out.println("调用QuService中利用setName方法设置属性值");
		this.name = name;
		return this;
	}
	
	 //通过<bean>的destroy-method属性指定的销毁方法
    public void destroyMethod() throws Exception {
        System.out.println("执行配置的destroy-method");
    }

    //通过<bean>的init-method属性指定的初始化方法
    public void initMethod() throws Exception {
        System.out.println("执行配置的init-method");
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		 System.out.println("执行InitializingBean接口的afterPropertiesSet方法");
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("执行DisposableBean接口的destroy方法");
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 System.out.println("执行setApplicationContext:: Bean Definition Names="
	                + Arrays.toString(applicationContext.getBeanDefinitionNames()));
	}


	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		 System.out.println("执行ApplicationEventPublisherAware接口的setApplicationEventPublisher");
	}


	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		 System.out.println("执行BeanClassLoaderAware接口的setBeanClassLoader,ClassLoader Name = " + classLoader.getClass().getName());
	}


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		 System.out.println("执行BeanFactoryAware接口的setBeanFactory,setBeanFactory:: quService bean singleton=" +  beanFactory.isSingleton("quService"));
	}


	@Override
	public void setBeanName(String name) {
		 System.out.println("执行BeanNameAware接口的setBeanName:: Bean Name defined in context="
	                + name);
	}


	@Override
	public void setEnvironment(Environment environment) {
		  System.out.println("执行EnvironmentAware接口的setEnvironment方法");
	}


	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		   System.out.println("执行ImportAware接口的setImportMetadata方法");
	}


	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {

        Resource resource = resourceLoader.getResource("classpath:spring-beans.xml");
        System.out.println("执行setResourceLoader:: Resource File Name="
                + resource.getFilename());
	}
	
	
	
	
}

package com.study.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/*
* @author quchengguo
* @version 2018年4月22日 上午11:17:44
*/
public class CustomerBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("执行BeanPostProcessor的postProcessBeforeInitialization方法,beanName=" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("执行BeanPostProcessor的postProcessAfterInitialization方法,beanName=" + beanName);
		return bean;
	}

}

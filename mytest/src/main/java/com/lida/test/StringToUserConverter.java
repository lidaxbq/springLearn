package com.lida.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;

import java.util.Collections;
import java.util.Set;

/**
 * @Author lida
 * @Date 2021/11/21 0021 9:27
 */
public class StringToUserConverter implements ConditionalGenericConverter {

	// 判断是否符合使用该转换器的条件
	@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return sourceType.getType().equals(String.class) && targetType.getType().equals(User.class);
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return Collections.singleton(new ConvertiblePair(String.class, User.class));
	}

	//转换逻辑
	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		User user = new User();
		user.setName(((String) source));
		return user;
	}

	//注册到spring 容器
	@Bean
	public ConversionServiceFactoryBean conversionServiceFactoryBean() {
		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
		conversionServiceFactoryBean.setConverters(Collections.singleton(new StringToUserConverter()));
		return conversionServiceFactoryBean;
	}

	//注册到spring 容器
	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		// 要被代理目标类的名字
		beanNameAutoProxyCreator.setBeanNames("userS*");
		// 指定使用哪个增强器
		beanNameAutoProxyCreator.setInterceptorNames("MyAdvice");
		return beanNameAutoProxyCreator;
	}

	@Bean
	public MethodInterceptor MyAdvice() {
		return new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				return null;
			}
		};
	}

	@Bean
	public DefaultPointcutAdvisor defaultPointcutAdvisor() {
		NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
		nameMatchMethodPointcut.setMappedName("test");

		DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
		defaultPointcutAdvisor.setPointcut(nameMatchMethodPointcut);
		defaultPointcutAdvisor.setAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				return null;
			}
		});


		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Resource resource = context.getResource("file://D:/a.xml");
		resource = context.getResource("http://www.baidu.com");
		resource = context.getResource("classpath:spring.xml");

		ConfigurableEnvironment environment = context.getEnvironment();
		environment.getSystemEnvironment();
		environment.getSystemProperties();
		environment.getPropertySources();
		return defaultPointcutAdvisor;
	}
}

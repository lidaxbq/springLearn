package com.lida;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

@SuppressWarnings("deprecation")
public class XmlMainTest {
	public static void main(String[] args) {

//		testBeanFactory();
//		testContext();
//		testJdbc();
//		testMybatis();
//		测试动态网容器中增加或者删除bean
		testAddAndDelete();
	}

	private static void testAddAndDelete() {
		//		 (ApplicationContext在读取配置文件的时候,配置文件中的bena就会被初始化(不考虑bean的作用域))
		ClassPathXmlApplicationContext  applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
		System.out.println(testBean.getName());
		TestBean testBean2 = (TestBean) applicationContext.getBean("testBean");
		System.out.println(testBean.equals(testBean2));
		BeanDefinitionRegistry beanDefReg = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
//		beanDefReg.getBeanDefinition(beanName);
		beanDefReg.removeBeanDefinition("testBean");
		try {
			testBean = (TestBean) applicationContext.getBean("testBean");
			System.out.println(testBean.getName());
		}catch (Exception e){
			e.printStackTrace();
		}

		BeanDefinitionBuilder beanDefBuilder = BeanDefinitionBuilder.genericBeanDefinition(TestBean.class);
		BeanDefinition beanDef = beanDefBuilder.getBeanDefinition();
		if (!beanDefReg.containsBeanDefinition("testBean")) {
			beanDefReg.registerBeanDefinition("testBean", beanDef);
		}
		testBean2 = (TestBean) applicationContext.getBean("testBean");
		System.out.println(testBean.equals(testBean2));
		System.out.println(testBean2.getName());
	}

	private static void testMybatis() {
//		sqlsess
	}

	private static void testJdbc() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.update("", "");
	}

	private static void testContext() {
//		 (ApplicationContext在读取配置文件的时候,配置文件中的bena就会被初始化(不考虑bean的作用域))
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
		System.out.println(testBean.getName());
	}

	static void testBeanFactory() {
		// 过时处理逻辑,XmlBeanFactory在3.1以后已经被废弃，不再推荐使用
//		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("springContext.xml"));
//		TestBean testBean = (TestBean) beanFactory.getBean("testBean");
//		System.out.println(testBean.getName());


		// 当前方案一：BeanFactory在启动的时候不会创建bean实例,而是在getBean()的时候,才会创建bean的实例
		Resource resource = new ClassPathResource("springContext.xml");
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		beanDefinitionReader.loadBeanDefinitions(resource);
		TestBean testBean = (TestBean) beanFactory.getBean("testBean");
		System.out.println(testBean.getName());

		testBean = (TestBean) beanFactory.getBean("testBean");
		System.out.println(testBean.getName());
	}
}

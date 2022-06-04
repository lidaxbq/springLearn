package com.lida.testTX;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author lida
 * @Date 2021/11/14 0014 15:12
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(config.class);
		MyService bean = annotationConfigApplicationContext.getBean(MyService.class);
		bean.deal();
	}
}

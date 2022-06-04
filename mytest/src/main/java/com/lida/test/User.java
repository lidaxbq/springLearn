package com.lida.test;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @Author lida
 * @Date 2021/11/21 0021 8:16
 */
@Component
@Conditional(value = {MyConditional.class})
public class User {
		private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

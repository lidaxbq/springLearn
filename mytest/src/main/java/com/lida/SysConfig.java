package com.lida;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SysConfig {
	@Bean
	public SysUser sysUser(){
		return new SysUser("zszxz","123");
	}
}
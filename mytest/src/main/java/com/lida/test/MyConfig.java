package com.lida.test;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.*;

import java.beans.PropertyEditor;
import java.util.HashMap;

/**
 * @Author lida
 * @Date 2021/11/21 0021 8:29
 */
@Configuration
public class MyConfig {
	@Bean
	public CustomEditorConfigurer customEditorConfigurer() {
		CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
		HashMap<Class<?>, Class<? extends PropertyEditor>> map = new HashMap<>();

		//spring在UserSevice类中发现，当前对象是string类型，而需要的类型是User时，就是应用该StringToUserPeopertyEditor做转换
		map.put(UserSevice.class, StringToUserPeopertyEditor.class);
		customEditorConfigurer.setCustomEditors(map);
		return customEditorConfigurer;
	}
}

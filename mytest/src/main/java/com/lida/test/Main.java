package com.lida.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author lida
 * @Date 2021/11/21 0021 8:09
 */
@Component
public class Main {
	@Autowired
	UserSevice userSevice;

	@PrototypeBean
	public UserSevice userSevice() {
		User user = userSevice.test();  //直接获取到user bean
		return new UserSevice();
	}
}

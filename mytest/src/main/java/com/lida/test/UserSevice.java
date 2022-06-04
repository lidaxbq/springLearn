package com.lida.test;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author lida
 * @Date 2021/11/21 0021 8:16
 */
@Component
public abstract class UserSevice {
	@Value("211")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

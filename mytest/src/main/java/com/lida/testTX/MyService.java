package com.lida.testTX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Author lida
 * @Date 2021/11/14 0014 15:10
 */
@org.springframework.stereotype.Service
public class MyService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional
	public void deal() throws Exception {
		System.out.println("MyService.deal");
		jdbcTemplate.execute("insert into test.user(name) value ('" + UUID.randomUUID().toString() + "')");
		throw new RuntimeException();
	}

}

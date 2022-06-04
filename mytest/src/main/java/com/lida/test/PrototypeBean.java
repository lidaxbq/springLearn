package com.lida.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author lida
 * @Date 2021/11/21 0021 8:12
 */
@Retention(RetentionPolicy.RUNTIME)
@Bean
@Scope("prototype")
public @interface PrototypeBean {
}

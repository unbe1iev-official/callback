package com.unbe1iev.callback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCallbackApplication {

	public static void main(String[] args) {
		SpringApplication.from(CallbackApplication::main).with(TestCallbackApplication.class).run(args);
	}
}

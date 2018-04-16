/**
 * 
 */
package com.bigbang.dubbo.provider.test.web;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author pzj 2018年4月16日上午11:51:52
 *
 */
public class DubboProviderTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.start();
		System.in.read();
	}
}

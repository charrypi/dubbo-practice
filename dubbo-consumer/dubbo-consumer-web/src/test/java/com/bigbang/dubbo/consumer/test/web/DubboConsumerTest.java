/**
 * 
 */
package com.bigbang.dubbo.consumer.test.web;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.bigbang.dubbo.common.service.CommonService;

/**
 * @author pzj 2018年4月16日上午11:59:30
 *
 */
public class DubboConsumerTest {

	private ClassPathXmlApplicationContext context;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.start();
	}

	// 结果缓存测试
	@Test
	public void visitService() throws IOException {
		CommonService commonService = (CommonService) context.getBean("commonService");

		long BefoTime = System.currentTimeMillis();
		String retrunStr = commonService.sayHello("bigbang");
		System.out.println("第1次返回：" + retrunStr);
		long spendTime = System.currentTimeMillis() - BefoTime;
		System.out.println("第1次请求花费时间：" + spendTime);

		BefoTime = System.currentTimeMillis();
		String secondReturn = commonService.sayHello("bigbang");
		System.out.println("第2次返回：" + secondReturn);
		spendTime = System.currentTimeMillis() - BefoTime;
		System.out.println("第2次请求花费时间：" + spendTime);
	}

	// 泛化引用测试
	@Test
	public void genericVisit() throws IOException {
		GenericService genericService = (GenericService) context.getBean("genericService");
		Object returnObj = genericService.$invoke("query", new String[] { "java.lang.String" },
				new Object[] { "bigbang92" });
		System.out.println("泛化请求返回: " + returnObj);
		System.in.read();
	}

	//回声测试
	@Test
	public void echoTest() {
		//所有服务都自动实现echoService接口，直接强制转换即可
		EchoService echoService = (EchoService) context.getBean("commonService");
		Object returnObj = echoService.$echo("ok?");
		assertEquals("ok?", returnObj);
	}

}

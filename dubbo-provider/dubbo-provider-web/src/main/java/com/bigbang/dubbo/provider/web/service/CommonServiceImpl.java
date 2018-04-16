/**
 * 
 */
package com.bigbang.dubbo.provider.web.service;

import com.bigbang.dubbo.common.service.CommonService;

/**
 * @author pzj 2018年4月16日上午11:09:44
 *
 */
public class CommonServiceImpl implements CommonService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bigbang.dubbo.common.service.CommonService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String name) {
		try {
			//休眠5s，测试是否从缓存获取数据
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
		}
		return "hello " + name;
	}

}

/**
 * 
 */
package com.bigbang.dubbo.provider.web.service;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * @author pzj 2018年4月16日下午4:52:19
 *
 */
public class GenericServiceImpl implements GenericService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.dubbo.rpc.service.GenericService#$invoke(java.lang.String,
	 * java.lang.String[], java.lang.Object[])
	 */
	@Override
	public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
		if (method.equals("query")) {
			return "query for what? return " + args[0];
		}
		return null;
	}

}

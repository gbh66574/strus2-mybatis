package com.entor.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TestInterceptor extends AbstractInterceptor {

	

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("测试拦截器功能");
		return invocation.invoke();//放行过滤，请求继续执行action
	}

}

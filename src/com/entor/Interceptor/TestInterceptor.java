package com.entor.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TestInterceptor extends AbstractInterceptor {

	

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("��������������");
		return invocation.invoke();//���й��ˣ��������ִ��action
	}

}

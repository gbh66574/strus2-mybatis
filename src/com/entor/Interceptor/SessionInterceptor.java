package com.entor.Interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class SessionInterceptor extends MethodFilterInterceptor  {

	
	@Override
	public String doIntercept(ActionInvocation arg0) throws Exception {
		if(ServletActionContext.getRequest().getSession().getAttribute("student")!=null) {
			return arg0.invoke();
		}
			return "login";
		}

	
}

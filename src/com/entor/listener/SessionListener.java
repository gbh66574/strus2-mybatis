package com.entor.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.entor.entity.Student;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public void sessionCreated(HttpSessionEvent event) {
		Student s=(Student)event.getSession().getAttribute("student");
		System.out.println("用户【"+s.getName()+"】上线！");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("用户登录超时");
		
	}
*/
}

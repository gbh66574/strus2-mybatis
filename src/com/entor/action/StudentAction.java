package com.entor.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.entor.dao.StudentDao;
import com.entor.dao.impl.StudentDaoimpl;
import com.entor.entity.Student;
import com.entor.service.StudentService;
import com.entor.service.impl.StudentServiceimpl;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport implements ServletRequestAware,ServletResponseAware  {
	private Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	private StudentService studentService =new StudentServiceimpl();
	private HttpServletRequest request;
	private HttpServletResponse response;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String currentPage;
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	private String ids;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String add() throws Exception{
		studentService.add(student);
		return "success";
		
	}
	public String addMore() throws Exception{

		return "success";
		
	}
	public String update()throws Exception {
		studentService.update(student);
		return "success";
		
	}
	public String deleteById()throws Exception {
		
	studentService.deleteById(id);
		return "success";
		
	}
	public String deleteMore()throws Exception {
		
		studentService.deleteMore(ids);
		return "success";
		
	}
	public String queryById()throws Exception {
		
		Student s = studentService.queryById(id);
		request.setAttribute("student", s);
		request.setAttribute("currentPage",currentPage);	
		return "queryById";
		
	}
	public String queryAll()throws Exception {
	
		return "success";
		
	}
	public String queryByPage()throws Exception {
		
		//褰撳墠椤�
		int sp = 1;
		//鎬昏褰曟暟
		int totals = studentService.getTotals();
		//姣忛〉璁板綍鏁�
		int pageSize = 20;
		//鎬婚〉鏁�
		int pageCounts = totals/pageSize;
		if(totals%pageSize!=0){
			pageCounts++;
		}
		try{
			sp = Integer.parseInt(currentPage);
		}catch(Exception e){
			sp = 1;
		}
		if(sp>pageCounts){
			sp = pageCounts;
		}
		if(sp<1){
			sp = 1;
		}
		List<Student> list = studentService.queryByPage(sp, pageSize);
		request.setAttribute("list", list);
		request.setAttribute("totals", totals);
		request.setAttribute("pageCounts", pageCounts);
		request.setAttribute("sp", sp);
		return "queryByPage";
		
	}
	public String login()throws Exception{
		Student s = studentService.login(student.getUsername(), student.getPassword());
		if(s!=null) {
			request.getSession().setAttribute("student", s);
			return "success";
		}else {
			request.setAttribute("msg", "鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒");
			return "login";
		}
	}
	public String logout()throws Exception{
		request.getSession().invalidate();
		return"login";
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request; 
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
}

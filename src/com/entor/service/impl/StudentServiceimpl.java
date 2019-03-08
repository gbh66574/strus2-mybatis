package com.entor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import com.entor.dao.StudentDao;
import com.entor.dao.impl.StudentDaoimpl;
import com.entor.entity.Student;
import com.entor.service.StudentService;


public class StudentServiceimpl implements StudentService {


	private StudentDao StudentDao=new StudentDaoimpl();
	
	@Override
	public void add(Student student) {
		StudentDao.add(student);
		
	}

	@Override
	public void addMore(List<Student> list) {
		StudentDao.addMore(list);
	}

	@Override
	public void deleteById(int id) {
	StudentDao.deleteById(id);
		
	}

	@Override
	public void deleteMore(String ids) {
		StudentDao.deleteMore(ids);
		
	}

	@Override
	public void update(Student student) {
		StudentDao.update(student);
		
	}

	@Override
	public Student queryById(int id) {
		
		return StudentDao.queryById(id);
	}

	@Override
	public List<Student> queryAll() {
		
		return StudentDao.queryAll();
	}

	@Override
	public List<Student> queryByPage(int currentPage, int pageSize) {
		
		return StudentDao.queryByPage(currentPage, pageSize);
	}

	@Override
	public int getTotals() {
		
		return StudentDao.getTotals();
	}

	@Override
	public Student login(String username, String password) {
		
		return StudentDao.login(username, password);
	}

}

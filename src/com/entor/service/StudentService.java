package com.entor.service;

import java.util.List;


import com.entor.entity.Student;

public interface StudentService {
public void add(Student student);
	
	public void addMore(List<Student> list);
	
	public void deleteById(int id);
	
	public void deleteMore(String ids);
	
	public void update(Student student);
	
	public Student queryById(int id);
	
	public List<Student> queryAll();
	
	public List<Student> queryByPage(int currentPage,int pageSize);
	
	public int getTotals();
	public Student login(String username,String password);
}

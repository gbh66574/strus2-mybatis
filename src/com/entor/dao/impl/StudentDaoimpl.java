package com.entor.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.entor.dao.StudentDao;
import com.entor.entity.Student;
import com.entor.util.MyBatisUtil;

public class StudentDaoimpl implements StudentDao {

	private final String namespace="com.entor.mapper.Student";
	@Override
	public void add(Student s) {
	SqlSession sqlSession=null;
	try {
		sqlSession=MyBatisUtil.getSqlSession();
		sqlSession.insert(namespace+".add", s);
		sqlSession.commit();
	}catch(Exception e){
		if(sqlSession!=null) {
			sqlSession.rollback();
		}
	}finally {
		if(sqlSession!=null) {
			sqlSession.close();
		}
	}
		
	}
	@Override
	public void addMore(List<Student> list) {
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			sqlSession.insert(namespace+".addMore", list);
			sqlSession.commit();
		}catch(Exception e){
			if(sqlSession!=null) {
				sqlSession.rollback();
			}
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}

	}

	@Override
	public void deleteById(int id) {
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			sqlSession.delete(namespace+".deleteById", id);
			sqlSession.commit();
		}catch(Exception e){
			if(sqlSession!=null) {
				sqlSession.rollback();
			}
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}

	@Override
	public void deleteMore(String ids) {
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			sqlSession.delete(namespace+".deleteMore",ids.split(","));
			sqlSession.commit();
		}catch(Exception e){
			if(sqlSession!=null) {
				sqlSession.rollback();
			}
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}

	@Override
	public void update(Student s) {
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			sqlSession.update(namespace+".update", s);
			sqlSession.commit();
		}catch(Exception e){
			if(sqlSession!=null) {
				sqlSession.rollback();
			}
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}

	@Override
	public Student queryById(int id) {
		SqlSession sqlSession=null;
		Student s=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			s=sqlSession.selectOne(namespace+".queryById", id);
			System.out.println(s);
		}catch(Exception e){
			if(sqlSession!=null) {
				sqlSession.rollback();
			}
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return s;
	}

	@Override
	public List<Student> queryAll() {
		SqlSession sqlSession=null;
		List<Student> list =null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			list=sqlSession.selectList(namespace+".queryAll");
			for(Student s:list) {
				System.out.println(s);
			}
		}catch(Exception e){
			if(sqlSession!=null) {
				sqlSession.rollback();
			}
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> queryByPage(int currentPage, int pageSize) {
		SqlSession sqlSession=null;
		List<Student> list = null;
		try {
			Map<String,Integer> map=new HashMap<>();
			map.put("start", (currentPage-1)*pageSize);
			map.put("pageSize", pageSize);
			sqlSession=MyBatisUtil.getSqlSession();
			return list=sqlSession.selectList(namespace+".queryByPage", map);
			/*for(Student s:list) {
				System.out.println(s);
			}*/
			 
		}catch(Exception e){
			if(sqlSession!=null) {
				sqlSession.rollback();
			}
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return list;
		
	}

	

	@Override
	public int getTotals() {
		SqlSession sqlSession=null;
		int totals=0;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			totals=sqlSession.selectOne(namespace+".getToals");
			System.out.println(totals);
		}catch(Exception e){
			if(sqlSession!=null) {
				sqlSession.rollback();
			}
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return totals;
	}
	@Override
	public Student login(String username, String password) {
		SqlSession sqlSession=null;
		Student s=null;
		try {
			Map<String, String>map=new HashMap<>();
			map.put("username", username);
			map.put("password", password);
			sqlSession=MyBatisUtil.getSqlSession();
			s=sqlSession.selectOne(namespace+".login", map);
			System.out.println(s);
		}catch(Exception e){
			if(sqlSession!=null) {
				sqlSession.rollback();
			}
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return s;
	}
	

//	@Override
//	public List<Student> queryByPage(int start, int pageSize, String condition) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int getTotals(String condtion) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	
}

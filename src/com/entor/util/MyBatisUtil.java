package com.entor.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			// 1.��ȡ�����ļ����ַ���������
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// 2.�������ݿ�־ò����ػ�����
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}

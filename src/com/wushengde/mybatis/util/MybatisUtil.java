package com.wushengde.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wushengde.mybatis.test.Test;

public class MybatisUtil {
	 public static SqlSessionFactory getFactory(){
		 String resource = "conf.xml";
		 //����mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		 InputStream isInputStream=Test.class.getClassLoader().getResourceAsStream(resource);
		//����sqlSession �Ĺ���
		 SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(isInputStream);
		 return sessionFactory;
	 }
}

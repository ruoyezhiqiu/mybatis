package com.wushengde.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws IOException {
		//Ϊ�˴�����,������SessionFactory�ķ�����װ�����߰���(�˴��Ͳ����÷�װ�Ĺ����ˣ�
		 String resource = "conf.xml";
		 //����mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		 InputStream isInputStream=Test.class.getClassLoader().getResourceAsStream(resource);
		//����sqlSession �Ĺ���
		 SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(isInputStream);
		//������ִ��ӳ���ļ���sql ��sqlSession
		 SqlSession session=sessionFactory.openSession();
		//ӳ��sql �ı�ʶ�ַ���
		 String statement="com.wushengde.mybatis.test.userMapper.getUser";
		//ִ�в�ѯ����һ��Ψһuser �����sql
		 User user=session.selectOne(statement,1);
		 System.out.println(user);
	}
}

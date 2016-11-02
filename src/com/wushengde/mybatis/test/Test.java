package com.wushengde.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws IOException {
		//为了代码简洁,将生成SessionFactory的方法封装到工具包中(此处就不调用封装的工具了）
		 String resource = "conf.xml";
		 //加载mybatis 的配置文件（它也加载关联的映射文件）
		 InputStream isInputStream=Test.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession 的工厂
		 SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(isInputStream);
		//创建能执行映射文件中sql 的sqlSession
		 SqlSession session=sessionFactory.openSession();
		//映射sql 的标识字符串
		 String statement="com.wushengde.mybatis.test.userMapper.getUser";
		//执行查询返回一个唯一user 对象的sql
		 User user=session.selectOne(statement,1);
		 System.out.println(user);
	}
}

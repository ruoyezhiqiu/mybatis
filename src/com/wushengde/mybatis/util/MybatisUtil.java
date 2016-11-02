package com.wushengde.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wushengde.mybatis.test.Test;

public class MybatisUtil {
	 public static SqlSessionFactory getFactory(){
		 String resource = "conf.xml";
		 //加载mybatis 的配置文件（它也加载关联的映射文件）
		 InputStream isInputStream=Test.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession 的工厂
		 SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(isInputStream);
		 return sessionFactory;
	 }
}

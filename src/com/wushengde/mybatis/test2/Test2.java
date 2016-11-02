package com.wushengde.mybatis.test2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.wushengde.mybatis.test.User;
import com.wushengde.mybatis.test3.UserMapper;
import com.wushengde.mybatis.util.MybatisUtil;

public class Test2 {
	//测试向数据库插入数据：
	@Test
	public void testAdd(){
		SqlSessionFactory foFactory=MybatisUtil.getFactory();
		//sqlSessionFactory中的openSession()方法默认是手动提交的，所以执行了addUser()方法后数据库中没有插入数据。
		SqlSession session=foFactory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.addUser";
		//insert变量表示向数据库中插入数据后，影响了几行数据。
		int insert=session.insert(statement,new User(-1, "hellokit", 3));
		//向数据库中提交。
		session.commit();
		//用完后关闭Session
		session.close();
		System.out.println(insert);
	}
	//测试更新数据库：
	@Test
	public void testUpdate(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.updateUser";
		int update=session.update(statement, new User(4, "hellocat", 5));
		//此处手动提交：
		session.commit();
		//用完后关闭Session
		session.close();
		System.out.println(update);
	}
	//测试删除数据库数据：
	@Test
	public void testDelete(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		//此处设置了自动提交，因此后边不需要再执行手动提交
		SqlSession session=factory.openSession(true);
		String statement="com.wushengde.mybatis.test2.userMapper.deleteUser";
		int delete = session.delete(statement, 4);
		//用完后关闭Session
		session.close();
		System.out.println(delete);
	}
	//测试根据ID查询单个用户：
	@Test
	public void testGetUser(){
		SqlSessionFactory factory = MybatisUtil.getFactory();
		SqlSession openSession = factory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.getUser";
		//查询所调用的方法：
		User user=openSession.selectOne(statement, 2);
		//用完后关闭Session
		openSession.close();
		System.out.println(user);
	}
	
	//关键点：查询所有用户
	@Test
	public void testGetAll(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession openSession = factory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.getAllUsers";
		List<User> selectList = openSession.selectList(statement);
		openSession.close();
		System.out.println(selectList);
	}
	
	
	//以下的测试都是采用注解写入SQL语句的方式：
	
	//向数据库添加一个用户：
	@Test
	public void newTestGetUser(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1, "郭嘉", 15));
		openSession.close();
		System.out.println(add);
	}
	//查询数据库中所有的用户：
	@Test
	public void newTestGetAllUser(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<User> all = mapper.getAll();
		openSession.close();
		System.out.println(all);
	}
}

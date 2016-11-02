package com.wushengde.mybatis.test2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.wushengde.mybatis.test.User;
import com.wushengde.mybatis.test3.UserMapper;
import com.wushengde.mybatis.util.MybatisUtil;

public class Test2 {
	//���������ݿ�������ݣ�
	@Test
	public void testAdd(){
		SqlSessionFactory foFactory=MybatisUtil.getFactory();
		//sqlSessionFactory�е�openSession()����Ĭ�����ֶ��ύ�ģ�����ִ����addUser()���������ݿ���û�в������ݡ�
		SqlSession session=foFactory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.addUser";
		//insert������ʾ�����ݿ��в������ݺ�Ӱ���˼������ݡ�
		int insert=session.insert(statement,new User(-1, "hellokit", 3));
		//�����ݿ����ύ��
		session.commit();
		//�����ر�Session
		session.close();
		System.out.println(insert);
	}
	//���Ը������ݿ⣺
	@Test
	public void testUpdate(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.updateUser";
		int update=session.update(statement, new User(4, "hellocat", 5));
		//�˴��ֶ��ύ��
		session.commit();
		//�����ر�Session
		session.close();
		System.out.println(update);
	}
	//����ɾ�����ݿ����ݣ�
	@Test
	public void testDelete(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		//�˴��������Զ��ύ����˺�߲���Ҫ��ִ���ֶ��ύ
		SqlSession session=factory.openSession(true);
		String statement="com.wushengde.mybatis.test2.userMapper.deleteUser";
		int delete = session.delete(statement, 4);
		//�����ر�Session
		session.close();
		System.out.println(delete);
	}
	//���Ը���ID��ѯ�����û���
	@Test
	public void testGetUser(){
		SqlSessionFactory factory = MybatisUtil.getFactory();
		SqlSession openSession = factory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.getUser";
		//��ѯ�����õķ�����
		User user=openSession.selectOne(statement, 2);
		//�����ر�Session
		openSession.close();
		System.out.println(user);
	}
	
	//�ؼ��㣺��ѯ�����û�
	@Test
	public void testGetAll(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession openSession = factory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.getAllUsers";
		List<User> selectList = openSession.selectList(statement);
		openSession.close();
		System.out.println(selectList);
	}
	
	
	//���µĲ��Զ��ǲ���ע��д��SQL���ķ�ʽ��
	
	//�����ݿ����һ���û���
	@Test
	public void newTestGetUser(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1, "����", 15));
		openSession.close();
		System.out.println(add);
	}
	//��ѯ���ݿ������е��û���
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

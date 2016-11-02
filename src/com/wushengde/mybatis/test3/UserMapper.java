package com.wushengde.mybatis.test3;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wushengde.mybatis.test.User;

/**
 * @author ruoyezhiqiu
 * ��UserMapper�ӿ�����Mybatis�ĵڶ���sql���д�뷽ʽ��ע��ķ�ʽ
 * ע��ʹ��ע��ķ�ʽҲ��Ҫ��conf.xml��ע�ᣬע��ķ�ʽ��xml��ʽ��һ����
 */
public interface UserMapper {
	//�����ݿ����һ����Ϣ��
	@Insert("insert into users(name,age) values(#{name},#{age})")
	public int add(User user);
	//�����ݿ�ɾ��һ����Ϣ��
	@Delete("delete from users where id=#{id}")
	public int deleteById(int id);
	//�������ݿ��е�һ����Ϣ��
	@Update("update users set  name=#{name},age=#{age} where id=#{id}")
	public int update(User user);
	//����ID�鿴���ݿ��ж�Ӧid�˵���Ϣ��
	@Select("select * from users where id=#{id}")
	public User getUser(int id);
	//��ѯ���ݿ��е�������Ϣ��
	@Select("select *from users")
	public List<User> getAll();
	
}

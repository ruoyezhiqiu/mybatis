package com.wushengde.mybatis.test3;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wushengde.mybatis.test.User;

/**
 * @author ruoyezhiqiu
 * 该UserMapper接口属于Mybatis的第二种sql语句写入方式：注解的方式
 * 注：使用注解的方式也需要在conf.xml中注册，注册的方式跟xml方式不一样。
 */
public interface UserMapper {
	//向数据库添加一条信息：
	@Insert("insert into users(name,age) values(#{name},#{age})")
	public int add(User user);
	//从数据库删除一条信息：
	@Delete("delete from users where id=#{id}")
	public int deleteById(int id);
	//更新数据库中的一条信息：
	@Update("update users set  name=#{name},age=#{age} where id=#{id}")
	public int update(User user);
	//根据ID查看数据库中对应id人的信息：
	@Select("select * from users where id=#{id}")
	public User getUser(int id);
	//查询数据库中的所有信息：
	@Select("select *from users")
	public List<User> getAll();
	
}

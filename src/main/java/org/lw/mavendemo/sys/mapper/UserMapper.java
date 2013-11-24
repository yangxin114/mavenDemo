package org.lw.mavendemo.sys.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.lw.mavendemo.sys.beans.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
	
	@Select("select * from sys_user where pk_id=#{id}")
	public User getUser(long id);
	
	@Select("select * from sys_user where userNo=#{no}")
	public User getUserByNo(String no);
	
	@Select("select count(pk_id) c from sys_user")
	public int countAll();
	
	@Insert("insert into sys_user (userNo,userName,firstName,middleName,lastName,password,passwordModifiedDate,email,comments,status,createDate,modifiedDate,loginDate,lastLoginDate,gender) "
	+"values(#{userNo},#{userName},#{firstName},#{middleName},#{lastName},#{password},#{passwordModifiedDate},#{email},#{comments},#{status},#{createDate},#{modifiedDate},#{loginDate},#{lastLoginDate},#{gender})")
	public void insert(User user);
}

package org.lw.mavendemo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.lw.mavendemo.sys.beans.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
	
	@Insert("insert sys_role (roleNo,roleName,description) values(${roleNo},${roleName},${description})")
	public void insert(Role role);
	
	@Delete("delete from sys_role where pk_id=${id}")
	public void delete(long id);
	
	@Delete("delete from sys_role where roleNo=${roleNo}")
	public void deleteByNo(String roleNo);
	
	@Select("select count(*) from sys_role")
	public int countAll();
	
	@Select("sselect  r.* from sys_role r left join sys_user_role ur on ur.roleNo = r.roleNo left join sys_user u on u.userNo = ur.userNo where u.userNo = ${userNo}")
	public List<Role> getRolesByUser(String userNo);
	
	@Select("select r.* from sys_role r left join sys_role_permission rp on rp.roleNo = r.roleNo left join sys_permission p on  rp.permNo=p. permNo left join sys_permission_resources pRes on pRes.permNo = p.permNo left join sys_resources res on res.resNo =  pRes.permNo where  res.resNo = ${resourceNo}")
	public List<Role> getRolesByResource(String resourceNo);
}

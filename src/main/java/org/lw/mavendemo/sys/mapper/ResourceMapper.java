package org.lw.mavendemo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.lw.mavendemo.sys.beans.Resource;
import org.lw.mavendemo.sys.beans.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMapper {
	@Insert("insert sys_resource (resNo,resName,resType,resUrl,resDesc) values(${resNo},${resName},${resType},${resUrl},${resDesc})")
	public void insert(Role role);
	
	@Delete("delete from sys_resource where pk_id=${id}")
	public void delete(long id);
	
	@Delete("delete from sys_resource where resNo=${resNo}")
	public void delete(String roleNo);
	
	@Select("select count(*) from sys_resource")
	public int countAll();
	
	@Select("select * from sys_resource")
	public List<Resource> getAll();
}

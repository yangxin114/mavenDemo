package org.lw.mavendemo.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.lw.mavendemo.sys.beans.Role;
import org.lw.mavendemo.sys.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	@Resource
	private RoleMapper roleMapper;

	public void insert(Role role) {
		roleMapper.insert(role);
	}

	public void delete(long id) {
		roleMapper.delete(id);
	}

	public void delete(String roleNo) {
		roleMapper.delete(roleNo);
	}

	public List<Role> getRolesByUser(String userNo) {
		return roleMapper.getRolesByUser(userNo);
	}

	public List<Role> getRolesByResource(String resourceNo) {
		return roleMapper.getRolesByResource(resourceNo);
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
}

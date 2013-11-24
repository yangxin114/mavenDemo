package org.lw.mavendemo.sys.mapper;

import org.lw.mavendemo.sys.beans.Role;

public interface RoleMapper {
	public void insert(Role role);
	public void delete(long id);
	public void delete(String roleNo);
	public int countAll();
}

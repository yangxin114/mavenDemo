package org.lw.mavendemo.sys.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lw.mavendemo.sys.beans.Role;
import org.lw.mavendemo.sys.service.RoleService;
import org.lw.mavendemo.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SysUserDetailService implements UserDetailsService {
	@Autowired
	public RoleService roleService;
	@Autowired
	public UserService userService;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		org.lw.mavendemo.sys.beans.User sysUser = userService
				.getUserByNo(username);
		List<Role> roles = roleService.getRolesByUser(username);
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			GrantedAuthorityImpl auth = new GrantedAuthorityImpl(
					role.getRoleNo());
			auths.add(auth);
		}

		User user = new User(username, sysUser.getPassword(), true, true, true,
				true, auths);
		return user;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

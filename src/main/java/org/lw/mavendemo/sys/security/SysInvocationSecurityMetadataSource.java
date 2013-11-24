package org.lw.mavendemo.sys.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lw.mavendemo.sys.beans.Resource;
import org.lw.mavendemo.sys.beans.Role;
import org.lw.mavendemo.sys.service.ResourceService;
import org.lw.mavendemo.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

/**
 * 该类两个作用： 1.初始化时，加载所有的资源清单 2.获得拥有当前资源访问权限的所有角色清单，即ConfigAttribute
 * 
 * @author yangxin114
 * 
 */
public class SysInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	@Autowired
	private ResourceService resourceService;
	@Autowired
	private RoleService roleService;
	
	private AntPathRequestMatcher matcher;
	private HashMap<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	private boolean expire = false; // 是否已过期，当角色/资源信息变更后，应该设置该属性设置为true

	public SysInvocationSecurityMetadataSource() {
		loadResources();
	}

	/**
	 * Load所有资源信息，初始化时加载
	 */
	public void loadResources() {
		List<Resource> resources = resourceService.getAll();
		if(resources == null)
			return ;
		for (Resource resource : resources) {
			List<Role> roles = roleService.getRolesByResource(resource
					.getResNo());
			Collection<ConfigAttribute> attrs = new ArrayList<ConfigAttribute>();
			for (Role role : roles) {
				ConfigAttribute attr = new SecurityConfig(role.getRoleNo());
				attrs.add(attr);
			}
			resourceMap.put(resource.getResNo(), attrs);
		}
	}

	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		// 如果已过期，则重新加载资源
		if (isExpire()) {
			resourceMap.clear();
			loadResources();
			expire = false;
		}

		FilterInvocation fi = (FilterInvocation) object;
		HttpServletRequest request = fi.getHttpRequest();
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			matcher = new AntPathRequestMatcher(resURL);
			if (matcher.matches(request)) {
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {

		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public HashMap<String, Collection<ConfigAttribute>> getResourceMap() {
		return resourceMap;
	}

	public void setResourceMap(
			HashMap<String, Collection<ConfigAttribute>> resourceMap) {
		this.resourceMap = resourceMap;
	}

	public boolean isExpire() {
		return expire;
	}

	public void setExpire(boolean expire) {
		this.expire = expire;
	}

	public void expireNow() {
		this.expire = true;
	}

}

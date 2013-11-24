package org.lw.mavendemo.sys.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 该类负责对权限访问进行验证
 * 
 * @author yangxin114
 * 
 */
public class SysAccessDecisionManager implements AccessDecisionManager {

	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null || configAttributes.isEmpty()) {
			return;
		}

		Collection<? extends GrantedAuthority> curRoles = authentication
				.getAuthorities();
		for (ConfigAttribute attr : configAttributes) {
			String role = attr.getAttribute();
			for (GrantedAuthority grantedAuthority : curRoles) {
				if (grantedAuthority.getAuthority().equals(role)) {
					return;
				}
			}
		}
		
		throw new AccessDeniedException("no right!");
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}

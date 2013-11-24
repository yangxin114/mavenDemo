package org.lw.mavendemo.sys.service;

import java.util.List;

import org.lw.mavendemo.sys.beans.Resource;
import org.lw.mavendemo.sys.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	/**
	 * public List<Resource> getResByUser(String userNo) { return null; }
	 **/

	public List<Resource> getAll() {
		return resourceMapper.getAll();
	}

	public ResourceMapper getResourceMapper() {
		return resourceMapper;
	}

	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}
}

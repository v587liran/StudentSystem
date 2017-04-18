package org.service;

import java.util.List;
import java.util.Map;

import org.pojo.Course;

public interface ICourseService {
	public void add(Course course) throws Exception;
	public void delete(String id) throws Exception;
	
	public void update(Course course) throws Exception;
	
	public Course findById(String id) throws Exception;
	
	public Map<String, Object> findAll(int pageNo,int pageSize,String keyword,String column) throws Exception;
}

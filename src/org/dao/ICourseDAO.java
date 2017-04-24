package org.dao;

import java.util.List;

import org.pojo.Course;

public interface ICourseDAO {
	public void insert(Course course) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public void update(Course course) throws Exception;
	
	public Course findById(String id) throws Exception;
	
	public List<Course> findAll(int pageNo,int pageSize,String keyword,String column)throws Exception;
	
	public int getCount(String keyword,String column) throws Exception;
}

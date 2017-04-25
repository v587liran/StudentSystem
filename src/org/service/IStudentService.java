package org.service;

import java.util.Map;

import org.pojo.Student;


public interface IStudentService {
	public void addStudent(Student student) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public void upDate(Student student) throws Exception;
	
	//验证登录
	public boolean isLogin(Student student) throws Exception;
	
	public Student findById(String id) throws Exception;
	
	public Map<String,Object> findAll(int pageNo,int pageSize,String keyword,String column) throws Exception;
	
	public String findLastId() throws Exception;
	
	public void selectCourse(Student user) throws Exception;
}

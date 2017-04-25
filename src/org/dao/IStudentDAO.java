package org.dao;

import java.util.List;

import org.pojo.Student;


public interface IStudentDAO {
	
	public void insert(Student student) throws Exception;

	public void delete(String id) throws Exception;
	
	public void upDate(Student student) throws Exception;
	
	public Student findById(String id) throws Exception;
	
	public List<Student> findAll(int pageNo,int pageSize,String keyword,String column) throws Exception;

	public int getAllCount(String keyword,String column) throws Exception;

	public String findLastId() throws Exception;
	
	public void updateSle(Student user) throws Exception;
}

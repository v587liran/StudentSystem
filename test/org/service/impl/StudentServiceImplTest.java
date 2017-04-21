package org.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.factory.AdminServiceFactory;
import org.factory.StudentServiceFactory;
import org.junit.Test;
import org.pojo.Admin;
import org.pojo.Student;

public class StudentServiceImplTest {

	@Test
	public void testAddStudent() throws Exception {
		Student student=new Student();
		student.setSid("1004");
		student.setPassword("123456");
		student.setSname("张三");
		StudentServiceFactory.getIStudentServiceInstance().addStudent(student);
	}

	@Test
	public void testDelete() throws Exception {
		StudentServiceFactory.getIStudentServiceInstance().delete("1004");
	}

	@Test
	public void testUpDate() throws Exception {
		Student student=new Student();
		student.setSid("1001");
		student.setPassword("123456");
		student.setSname("李四");
		student.setTelephone("110");
		StudentServiceFactory.getIStudentServiceInstance().upDate(student);
		System.out.println(StudentServiceFactory.getIStudentServiceInstance().findById("1001").getTelephone());
	}

	@Test
	public void testFindById() throws Exception {
		Student student=StudentServiceFactory.getIStudentServiceInstance().findById("1002");
		System.out.println(student.getSid()+student.getPassword());
	}

	@Test
	public void testFindAll() throws Exception {
		Map<String,Object> map=new HashMap<String ,Object>();
		map=StudentServiceFactory.getIStudentServiceInstance().findAll(1, 2, "", "sid");
		List<Student> list=(List<Student>)map.get("findAll");
		int count=(Integer) map.get("allCount");
		int sum=count+1;
		System.out.println(sum);
		
		for(Student l:list){
			System.out.println(l.getPassword());
		}
	}

	@Test
	public void testLogin() throws Exception {
		Student student=new Student();
		student.setSid("1001");
		student.setPassword("123456");
		boolean flag=false;
		flag=StudentServiceFactory.getIStudentServiceInstance().isLogin(student);
		
		System.out.println(student.getSid()+"-----"+student.getPassword()+"--------"+student.getSname());
		System.out.println(flag);
	}
	
	@Test
	public void testAdminLogin() throws Exception {
		Admin admin=new Admin();
		admin.setAid("100");
		admin.setApassword("110");
		boolean flag=false;
		flag=AdminServiceFactory.getIAdminServiceInstance().idLogin(admin);
		System.out.println(flag);
	}
	 
}

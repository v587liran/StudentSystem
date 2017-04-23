package org.pojo;


import java.util.HashSet;
import java.util.Set;

import org.factory.CourseServiceFactory;
import org.factory.StudentServiceFactory;
import org.hibernate.Transaction;
import org.jdbc.HibernateSessionFactory;
import org.junit.Test;

public class StudentTest {
	
	@Test
	public void testAdd() throws Exception{

	}
	
	@Test
	public void test() throws Exception {
		Student student=(Student) HibernateSessionFactory.getSession().get(Student.class, "1001");
		Set<Course> set=new HashSet<Course>();
		set=student.getCourses();
		
		for(Course c:set){
			System.out.println(c.getCname());
		}
		
		Course course=CourseServiceFactory.getICourseServiceInstance().findById("111");
		set.add(course);
		
		student.setCourses(set);
		
		StudentServiceFactory.getIStudentServiceInstance().upDate(student);
		
		student=(Student) HibernateSessionFactory.getSession().get(Student.class, "1001");
		
		System.out.println("111");
		
		set=new HashSet<Course>();
		set=student.getCourses();
		
		for(Course c:set){
			System.out.println(c.getCname());
		}
		
//		String[] courseid={"112","114","115","118"};
//	
//		for(int i=0;i<courseid.length;i++){
//			Course course=new Course();
//			course.setCid(courseid[i]);
//			student.getCourses().add(course);
//		}
//		
//		HibernateSessionFactory.getSession().update(student);
//		
//		
//		
//		Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
//		tx.commit();
//		HibernateSessionFactory.closeSession();
	}
	
	@Test
	public void test1() {
		Set<String> all=new HashSet<String>();
		all.add("1");
		all.add("2");
		all.add("3");
		all.add("4");
		all.add("5");
		all.add("6");
	
		for(String a:all){
			System.out.println(a);
		}
	}
	@Test
	public void test2() throws Exception{
		Student student=new Student();
		student.setSid("1001");
		student.setPassword("1234");
		boolean flag=false;
		flag=StudentServiceFactory.getIStudentServiceInstance().isLogin(student);
		System.out.println(student.getAddress());
	}
	
	@Test
	public void add() throws Exception{
		String maxIdString="";
		maxIdString=StudentServiceFactory.getIStudentServiceInstance().findLastId();
		System.out.println(maxIdString);
	}
	
	
}




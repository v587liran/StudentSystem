package org.pojo;


import org.hibernate.Transaction;
import org.jdbc.HibernateSessionFactory;
import org.junit.Test;

public class StudentTest {

	@Test
	public void test() {
		Student student=(Student) HibernateSessionFactory.getSession().get(Student.class, "1001");
		
		String[] courseid={"112","114","115","118"};
	
		for(int i=0;i<courseid.length;i++){
			Course course=new Course();
			course.setCid(courseid[i]);
			student.getCourses().add(course);
		}
		
		HibernateSessionFactory.getSession().update(student);
		
		Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	

}

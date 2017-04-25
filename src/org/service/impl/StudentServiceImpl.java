package org.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.factory.StudentDAOFactory;
import org.hibernate.Transaction;
import org.jdbc.HibernateSessionFactory;
import org.pojo.Student;
import org.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	@Override
	public void addStudent(Student student) throws Exception {
		try {
			Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
			StudentDAOFactory.getIStudentDAOInstance().insert(student);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public void delete(String id) throws Exception {
		try {
			Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
			StudentDAOFactory.getIStudentDAOInstance().delete(id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public void upDate(Student student) throws Exception {
		try {
			Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
			StudentDAOFactory.getIStudentDAOInstance().upDate(student);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}

	}

	@Override
	public boolean isLogin(Student student) throws Exception {
		boolean flag = false;
		try {
			Student students = StudentDAOFactory.getIStudentDAOInstance().findById(student.getSid());
			if (students!=null && student.getPassword().equals(students.getPassword())) {
				student.setSid(students.getSid());
				student.setPassword(students.getPassword());
				student.setSname(students.getSname());
				student.setGender(students.getGender());
				student.setBirthday(students.getBirthday());
				student.setAddress(students.getAddress());
				student.setTelephone(students.getTelephone());
				student.setCourses(students.getCourses());
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return flag;
	}

	@Override
	public Student findById(String id) throws Exception {
		Student student = null;
		try {
			student = StudentDAOFactory.getIStudentDAOInstance().findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return student;
	}

	@Override
	public Map<String, Object > findAll(int pageNo, int pageSize, String keyword,String column) throws Exception {
		Map<String, Object> map=new HashedMap();
		try {
			map.put("findAll", StudentDAOFactory.getIStudentDAOInstance().findAll(pageNo,pageSize, keyword, column));
			map.put("allCount", StudentDAOFactory.getIStudentDAOInstance().getAllCount(keyword,column));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return map;
	}

	@Override
	public String findLastId() throws Exception {
		String id="";
		try {
			id=StudentDAOFactory.getIStudentDAOInstance().findLastId();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return id;
	}

	@Override
	public void selectCourse(Student user) throws Exception {
		Transaction tx = HibernateSessionFactory.getSession().beginTransaction();
		try {
			StudentDAOFactory.getIStudentDAOInstance().updateSle(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
}

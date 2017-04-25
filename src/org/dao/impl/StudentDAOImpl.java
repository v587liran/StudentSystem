package org.dao.impl;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.dao.IStudentDAO;
import org.hibernate.Query;
import org.jdbc.HibernateSessionFactory;
import org.pojo.Student;


public class StudentDAOImpl implements IStudentDAO {

	@Override
	public void insert(Student student) throws Exception {
		HibernateSessionFactory.getSession().save(student);
	}

	@Override
	public void delete(String id) throws Exception {
		Student student=(Student) HibernateSessionFactory.getSession().get(Student.class, id);
		HibernateSessionFactory.getSession().delete(student);
	}

	@Override
	public void upDate(Student student) throws Exception {
		HibernateSessionFactory.getSession().update(student);
	}

	@Override
	public Student findById(String id) throws Exception {
		return (Student) HibernateSessionFactory.getSession().get(Student.class, id);
	}

	@Override
	public List<Student> findAll(int pageNo, int pageSize,String keyword, String column) throws Exception {
		String hql="FROM Student AS s WHERE s."+column+" LIKE ?";
		Query query=HibernateSessionFactory.getSession().createQuery(hql);
		query.setString(0, "%"+keyword+"%");
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public int getAllCount(String keyword,String column) throws Exception {
		String hql="SELECT COUNT(n) FROM Student AS n WHERE n."+column+" LIKE ?";
		Query query=HibernateSessionFactory.getSession().createQuery(hql);
		query.setString(0, "%"+keyword+"%");
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public String findLastId() throws Exception {
		String hql="FROM Student";
		int allCount=getAllCount("", "sid");
		System.out.println("--------------"+allCount);
		Query query=HibernateSessionFactory.getSession().createQuery(hql);
		query.setMaxResults(allCount);
		return ((Student)(query.list().get(0))).getSid();
	}

	@Override
	public void updateSle(Student user) throws Exception {
		HibernateSessionFactory.getSession().update(user);
		Student re = (Student) ServletActionContext.getRequest().getSession().getAttribute("student");
		user.setCourses(re.getCourses());
	}
}
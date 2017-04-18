package org.dao.impl;

import java.util.List;

import org.dao.ICourseDAO;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.jdbc.HibernateSessionFactory;
import org.pojo.Course;

public class CourseDAOImpl implements ICourseDAO {

	@Override
	public void insert(Course course) throws Exception {
		HibernateSessionFactory.getSession().save(course);
	}

	@Override
	public void delete(String id) throws Exception {
		Course course=(Course) HibernateSessionFactory.getSession().get(Course.class, id);
		HibernateSessionFactory.getSession().delete(course);
	}

	@Override
	public void update(Course course) throws Exception {
		HibernateSessionFactory.getSession().update(course);

	}

	@Override
	public Course findById(String id) throws Exception {
		return (Course)HibernateSessionFactory.getSession().get(Course.class, id);
	}

	@Override
	public List<Course> findAll(int pageNo, int pageSize, String keyword,String column) throws Exception {
		String hql="FROM Course AS c WHERE c."+column+" LIKE ?";
		Query query=HibernateSessionFactory.getSession().createQuery(hql);
		query.setString(0, "%"+keyword+"%");
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public int getCount(String keyword, String column) throws Exception {
		String hql="SELECT COUNT(*) FROM Course AS c WHERE c."+column+" LIKE ?";
		Query query=HibernateSessionFactory.getSession().createQuery(hql);
		query.setString(0, "%"+keyword+"%");
		return ((Long)query.uniqueResult()).intValue();
	}
}

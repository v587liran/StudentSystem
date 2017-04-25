package org.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.factory.CourseDAOFactory;
import org.factory.CourseServiceFactory;
import org.hibernate.Transaction;
import org.jdbc.HibernateSessionFactory;
import org.pojo.Course;
import org.service.ICourseService;

public class CourseServiceImpl implements ICourseService {

	@Override
	public void add(Course course) throws Exception {
		Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
		try {
			CourseDAOFactory.getICourseDAOInstance().insert(course);
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
		Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
		try {
			CourseDAOFactory.getICourseDAOInstance().delete(id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public void update(Course course) throws Exception {
		Transaction tx=HibernateSessionFactory.getSession().beginTransaction();
		try {
			CourseDAOFactory.getICourseDAOInstance().update(course);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Course findById(String id) throws Exception {
		Course course=null;
		try {
			course=CourseDAOFactory.getICourseDAOInstance().findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return course;
	}

	@Override
	public Map<String, Object> findAll(int pageNo, int pageSize,String keyword, String column) throws Exception {
		Map< String , Object> map=new HashMap<String, Object>();
		try {
			map.put("findAll", CourseDAOFactory.getICourseDAOInstance().findAll(pageNo, pageSize, keyword, column));
			map.put("allCount", CourseDAOFactory.getICourseDAOInstance().getCount(keyword,column));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return map;
	}

	@Override
	public Course courseFindById(String cid) throws Exception {
		try {
			return  CourseDAOFactory.getICourseDAOInstance().findById(cid);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Map<String, Object> list(int pageNo, int pageSize, String keyword,String column) throws Exception {
		Map<String, Object> map =new HashMap<String, Object>();
		try {
			map.put("allCourses",CourseDAOFactory.getICourseDAOInstance().findAll(pageNo,
					pageSize, keyword, column) );
			map.put("count", CourseDAOFactory.getICourseDAOInstance().getCount(keyword, 
					column));
		} catch (Exception e) {
			e.printStackTrace();
                throw e;
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return map;
	}
}

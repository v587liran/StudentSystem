package org.factory;

import org.dao.ICourseDAO;
import org.dao.impl.CourseDAOImpl;

public class CourseDAOFactory {
	public static ICourseDAO getICourseDAOInstance() throws Exception{
		return new CourseDAOImpl();
	}
}

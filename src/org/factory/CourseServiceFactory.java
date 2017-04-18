package org.factory;

import org.service.ICourseService;
import org.service.impl.CourseServiceImpl;

public class CourseServiceFactory {
	public static ICourseService getICourseServiceInstance() throws Exception{
		return new CourseServiceImpl();
	}
}

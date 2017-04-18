package org.factory;

import org.service.IStudentService;
import org.service.impl.StudentServiceImpl;

public class StudentServiceFactory {
	public static IStudentService getIStudentServiceInstance() {
		return new StudentServiceImpl();
	}
}

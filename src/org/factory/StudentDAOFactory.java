package org.factory;

import org.dao.IStudentDAO;
import org.dao.impl.StudentDAOImpl;

public class StudentDAOFactory {
	public static IStudentDAO getIStudentDAOInstance(){
		return new StudentDAOImpl();
	}
}

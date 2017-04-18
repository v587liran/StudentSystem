package org.factory;

import org.dao.IAdminDAO;
import org.dao.impl.AdminDAOImpl;

public class AdminDAOFactory {
	
	public static IAdminDAO getIAdminDAOInstance() throws Exception{
		return new AdminDAOImpl();
	}
	
}

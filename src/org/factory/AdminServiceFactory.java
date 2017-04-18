package org.factory;

import org.service.IAdminService;
import org.service.impl.AdminServiceImpl;

public class AdminServiceFactory {
	
	public static IAdminService getIAdminServiceInstance() throws Exception{
		return new AdminServiceImpl();
	}
	
}

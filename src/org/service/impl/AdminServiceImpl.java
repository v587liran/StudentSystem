package org.service.impl;

import org.factory.AdminDAOFactory;
import org.jdbc.HibernateSessionFactory;
import org.pojo.Admin;
import org.service.IAdminService;

public class AdminServiceImpl implements IAdminService {

	@Override
	public boolean idLogin(Admin admin) throws Exception {
		
		Admin admins=null;
		try {
			admins=AdminDAOFactory.getIAdminDAOInstance().findAdmin(admin);
			if(admins!=null){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return false;
	}

}

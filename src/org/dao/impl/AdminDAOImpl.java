package org.dao.impl;

import org.dao.IAdminDAO;
import org.hibernate.Query;
import org.jdbc.HibernateSessionFactory;
import org.pojo.Admin;

public class AdminDAOImpl implements IAdminDAO {

	@Override
	public Admin findAdmin(Admin admin) throws Exception {
		String hql="FROM Admin AS a WHERE a.aid=? AND a.apassword=?";
		Query query=HibernateSessionFactory.getSession().createQuery(hql);
		query.setString(0, admin.getAid());
		query.setString(1, admin.getApassword());
		return (Admin) query.uniqueResult();
	}
}

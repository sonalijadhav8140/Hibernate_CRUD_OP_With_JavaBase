package com.sit.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sit.configuration.HibernateUtil;

public class delete {
   
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		     Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Student where id=:id");
		query.setParameter("id",101);
		int  execute = query.executeUpdate();
		tx.commit();
		
	}
}

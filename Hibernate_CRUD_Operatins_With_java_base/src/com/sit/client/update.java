package com.sit.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sit.configuration.HibernateUtil;

public class update {
      
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
		Query query = session.createQuery("update Student set name=:sname,email=:semail where id=:id");
		
		query.setParameter("sname","sonali");
		query.setParameter("semail", "sonalijadhav@gmail.com");
		query.setParameter("id",101);      
		Transaction tx = session.beginTransaction();
		       int update = query.executeUpdate();
               tx.commit();		
		
	}
}

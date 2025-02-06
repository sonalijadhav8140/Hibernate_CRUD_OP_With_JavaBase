package com.sit.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sit.configuration.HibernateUtil;
import com.sit.model.Student;

public class Insert {
	
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		       Session session = sessionFactory.openSession();
		 
		       
		       Student st=new Student();
		       
		       st.setRollno(101);
		       st.setName("Dnyani");
		       st.setEmail("sonalijadhav6572@gmail.com");
		       st.setAddress("Baramati");
		      
		       //In HQL(Hibernate Query Language) We dont have HQL Query for insert.
		       //We just use save metho to save data in database.
		       
		       session.save(st);
		       
		       session.beginTransaction().commit();
		       
		
		
	}

}

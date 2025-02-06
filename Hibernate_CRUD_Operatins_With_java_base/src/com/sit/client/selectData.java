package com.sit.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sit.configuration.HibernateUtil;
import com.sit.model.Student;

public class selectData {


	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Select All Data From Teh Table
		
		Query query = session.createQuery("from Student");
		List<Student> list = query.getResultList();
		
		for(Student stu:list)
		{
			System.out.println(stu.getRollno());
			System.out.println(stu.getName());
			System.out.println(stu.getEmail());
			System.out.println(stu.getAddress());
			
		}
		
		
		//get Single Data
		
		Query query2 = session.createQuery("from Student where id=:id");
		query2.setParameter("id",101);
		Student st=(Student) query2.getSingleResult();
		
		System.out.println(st);
		
	}
}

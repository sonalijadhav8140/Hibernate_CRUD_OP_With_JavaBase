package com.sit.configuration;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.sit.model.Student;


public class HibernateUtil {
    
	private static SessionFactory sessionFactory=null;
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
		
			Map<Object,String> setting=new HashMap<Object, String>();
			setting.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			setting.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate_crud_javabase");
			setting.put(Environment.USER,"root");
			setting.put(Environment.PASS, "root");
			setting.put(Environment.SHOW_SQL,"true");
			setting.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
			setting.put(Environment.HBM2DDL_AUTO,"update");
//			setting.put(Environment.USE_SECOND_LEVEL_CACHE,"true");
//			setting.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
//			
			
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(setting).build();
			     MetadataSources mds = new MetadataSources(registry);
			                    mds.addAnnotatedClass(Student.class);
			                    Metadata md = mds.getMetadataBuilder().build();
			                     sessionFactory = md.buildSessionFactory();
			                    
		}
		return sessionFactory;
		
		
	}
	
}

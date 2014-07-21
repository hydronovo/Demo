package com.example.hibernate;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadDB {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();

		@SuppressWarnings("deprecation")
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			String hql = User.class.getName();
			hql = "FROM " + hql;
			Query query = session.createQuery(hql);
			ArrayList<User> users =  (ArrayList<User>) query.list();
			
			
			for (int i = 0; i < users.size(); i++) {
				System.out.println(users.get(i).getId());
				System.out.println(users.get(i).getUsername());
				System.out.println(users.get(i).getPassword());
				System.out.println(users.get(i).getCreateTime().getTime());
				System.out.println("");
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					// 关闭session
					session.close();
				}
			}
		}
		
		
	
	}
}

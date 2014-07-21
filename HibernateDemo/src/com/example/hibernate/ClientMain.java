package com.example.hibernate;

import java.util.ArrayList;
import java.util.List;

import javassist.expr.NewArray;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.auto.Client;

public class ClientMain {

	@SuppressWarnings({ "unchecked"})
	public static <T> List<T> select(String sql, Object... params) {
		List<T> list = new ArrayList<T>();
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
			list = (List<T>) query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtil.rollback(session.getTransaction());
			return null;
		} finally {
			HibernateUtil.closeSession(session);
		}
		return list;
	}

	public static <T> boolean batchUpdate(List<T> objects) {
		if (objects == null) {
			return false;
		}
		Configuration cfg = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			for (int i = 0; i < objects.size(); i++) {
				T obj = objects.get(i);
				if (obj == null) {
					continue;
				}
				session.save(obj);
				if (i % 1000 == 0) {
					session.flush();
					session.clear();
				}
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					session.close();
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// List<Client> clients = new ArrayList<Client>();
		// for (int i = 0; i < 10000; i++) {
		// Client client = new Client();
		// client.setLastName("123");
		// client.setFirstName("321");
		// clients.add(client);
		// }

		// batchUpdate(clients);
		//List<Client> clients = select("select * from Client where id = ? or id = ?", 1, 2);
//		List<Client> clients = select("select * from Client");
//		System.out.println(clients.size());
//		Client client = (Client) HibernateUtil.get(Client.class, 1);
//		System.out.println(client.getId());
		Client client = new Client();
		client.setId(2l);
		//HibernateUtil.delete(client);
		HibernateUtil.get(Client.class, client);
	}
}
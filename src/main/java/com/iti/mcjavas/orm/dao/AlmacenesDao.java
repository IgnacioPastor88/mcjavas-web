package com.iti.mcjavas.orm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.iti.mcjavas.orm.model.Almacenes;
import com.iti.mcjavas.orm.utils.HibernateUtil;

/**
 * @author WILMER
 *
 */
public class AlmacenesDao {

	@SuppressWarnings("unchecked")
	public static List<Almacenes> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Almacenes.class);
		// criteria.addOrder(Order.asc("Id_Almacenes"));
		criteria.addOrder(Order.asc("Pais")).addOrder(Order.asc("Nombre"));
		return criteria.list();
	}

	public void addUser(Almacenes almacenes) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(almacenes);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void deleteUser(int almacenesId) {
		Transaction trns = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Almacenes almacenes = (Almacenes) session.load(Almacenes.class,
					new Integer(almacenesId));
			session.delete(almacenes);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void updateUser(Almacenes franquicia) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(franquicia);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public Almacenes getUserById(int almacenesId) {
		Almacenes almacen = null;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from Almacenes where Id_Almacenes = :Id_Almacenes";
			Query query = session.createQuery(queryString);
			query.setInteger("Id_Almacenes", almacenesId);
			almacen = (Almacenes) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return almacen;
	}

}

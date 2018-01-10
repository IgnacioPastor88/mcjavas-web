package com.iti.mcjavas.orm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.iti.mcjavas.orm.model.Franquicias;
import com.iti.mcjavas.orm.utils.HibernateUtil;

/**
 * @author WILMER
 *
 */
public class FranquiciasDao {

	@SuppressWarnings("unchecked")
	public List<Franquicias> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Franquicias.class);

		// criteria.addOrder(Order.asc("Id_franquicia"));
		criteria.addOrder(Order.asc("Pais")).addOrder(Order.asc("Nombre"));
		return criteria.list();
	}

	public void addUser(Franquicias franquicias) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(franquicias);
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

	public void deleteUser(int franquiciasId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Franquicias franquicias = (Franquicias) session.load(Franquicias.class, new Integer(franquiciasId));
			session.delete(franquicias);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void updateUser(Franquicias franquicia) {
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

	public Franquicias getUserById(int franquiciasId) {
		Franquicias franquicia = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String queryString = "from Franquicias where Id_franquicia = :Id_franquicia";
			Query query = session.createQuery(queryString);
			query.setInteger("Id_franquicia", franquiciasId);
			franquicia = (Franquicias) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return franquicia;
	}

}

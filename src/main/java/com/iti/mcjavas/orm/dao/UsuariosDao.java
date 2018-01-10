package com.iti.mcjavas.orm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.iti.mcjavas.orm.model.Usuarios;
import com.iti.mcjavas.orm.utils.HibernateUtil;

/**
 * @author WILMER
 *
 */
public class UsuariosDao {

	@SuppressWarnings("unchecked")
	public List<Usuarios> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Usuarios.class);
		criteria.addOrder(Order.asc("IdUsuario"));
		return criteria.list();
	}

	public void addUser(Usuarios usuarios) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(usuarios);
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

	public void deleteUser(int userid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Usuarios usuarios = (Usuarios) session.load(Usuarios.class, new Integer(userid));
			session.delete(usuarios);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void updateUser(Usuarios user) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.update(user);
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

	public Usuarios getUserById(int userid) {
		Usuarios user = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String queryString = "from Usuarios where IdUsuario = :IdUsuario";
			Query query = session.createQuery(queryString);
			query.setInteger("IdUsuario", userid);
			user = (Usuarios) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return user;
	}

	public static boolean checkUserByEmailPassword(String userEmail, String userPassword) {
		boolean existeUsuario = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String queryString = "from Usuarios where Email = :Email and Password = :Password";
			Query query = session.createQuery(queryString);
			query.setString("Email", userEmail).setString("Password", userPassword);

			if ((Usuarios) query.uniqueResult() == null) {
				existeUsuario = false;
			} else {
				existeUsuario = true;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return existeUsuario;
	}

	public static boolean isLogedUserAdmin(String userEmail) {

		boolean isUserAdmin = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String queryString = "select u.Roles from Usuarios u where Email = :Email";
			Query query = session.createQuery(queryString);
			query.setString("Email", userEmail);

			String rol = (String) query.uniqueResult();

			if (rol.equals("admin")) {
				isUserAdmin = true;
			} else {
				isUserAdmin = false;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return isUserAdmin;
	}
}

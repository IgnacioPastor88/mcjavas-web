package com.iti.mcjavas.orm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.iti.mcjavas.orm.model.Freight;
import com.iti.mcjavas.orm.utils.HibernateUtil;

public class FreightDao {

	Session session = HibernateUtil.getSessionFactory().openSession();

	@SuppressWarnings("unchecked")
	public List<Freight> findAll() {
		Criteria criteria = session.createCriteria(Freight.class);
		criteria.addOrder(Order.asc("name"));
		return criteria.list();
	}

}
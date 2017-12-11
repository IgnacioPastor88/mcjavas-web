package com.iti.mcjavas.orm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.iti.mcjavas.orm.model.Schedule;
import com.iti.mcjavas.orm.utils.HibernateUtil;

public class ScheduleDao {
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	@SuppressWarnings("unchecked")
	public List<Schedule> findAll() {
		Criteria criteria = session.createCriteria(Schedule.class);
		return criteria.list();
	}
	
}
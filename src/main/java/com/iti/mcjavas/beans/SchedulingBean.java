package com.iti.mcjavas.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.iti.mcjavas.orm.dao.ScheduleDao;
import com.iti.mcjavas.orm.model.Schedule;

@ViewScoped
@ManagedBean
public class SchedulingBean implements Serializable {

	private static final long serialVersionUID = 1895464451959165416L;

	private Integer value;

	private ScheduleDao scheduleDao = new ScheduleDao();

	public void init() {
		List<Schedule> schedules = scheduleDao.findAll();
		value = schedules.size();
	}

	// GETTERS & SETTERS
	public Integer getValue() {
		return value;
	}

}

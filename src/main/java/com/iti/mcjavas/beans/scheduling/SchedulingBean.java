package com.iti.mcjavas.beans.scheduling;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class SchedulingBean implements Serializable {

	private static final long serialVersionUID = 1895464451959165416L;

	private SchedulingLogic schedulingLogic = new SchedulingLogic();

	private Integer truckCapacity;
	private List<FreightQuantity> freightInputs;
	private List<FreightQuantity> freightOptimals;


	public void init() {
		freightInputs = schedulingLogic.loadFreights();
	}
	
	public void calculateOptimalLoad(){
		freightOptimals = schedulingLogic.calculateOptimalLoad(truckCapacity, freightInputs);
	}
	
	public void reloadOptimalLoad(){
		freightOptimals = null;
		freightInputs = schedulingLogic.loadFreights();
	}

	// GETTERS & SETTERS

	public Integer getTruckCapacity() {
		return truckCapacity;
	}

	public void setTruckCapacity(Integer truckCapacity) {
		this.truckCapacity = truckCapacity;
	}

	public List<FreightQuantity> getFreightInputs() {
		return freightInputs;
	}

	public void setFreightInputs(List<FreightQuantity> freightInputs) {
		this.freightInputs = freightInputs;
	}
	
	public List<FreightQuantity> getFreightOptimals() {
		return freightOptimals;
	}
}

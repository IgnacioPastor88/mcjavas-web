package com.iti.mcjavas.beans.scheduling;

import com.iti.mcjavas.orm.model.Freight;

public class FreightQuantity {

	private int id;
	private String name;
	private Integer weight;
	private Integer value;
	private Integer quantity;

	public FreightQuantity(Freight freight) {
		this.id = freight.getId();
		this.name = freight.getName();
		this.weight = freight.getWeight();
		this.value = freight.getValue();
		this.quantity = 0;
	}

	public Freight loadFreight() {
		Freight freight = new Freight();
		freight.setId(id);
		freight.setName(name);
		freight.setWeight(weight);
		freight.setValue(value);
		return freight;
	}

	// GETTERS & SETTERS

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getValue() {
		return value;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
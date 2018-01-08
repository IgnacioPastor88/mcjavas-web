package com.iti.mcjavas.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Almacenes")
public class Almacenes {

	@Id
	@GeneratedValue
	@Column(name = "Id_Almacenes")
	private int Id_Almacenes;
	@Column(name = "Latitud")
	private String Latitud;
	@Column(name = "Longitud")
	private String Longitud;
	@Column(name = "Nombre")
	private String Nombre;
	@Column(name = "Direccion")
	private String Direccion;
	@Column(name = "Pais")
	private String Pais;

	@Transient
	private boolean selectedToRoute;

	// GETTERS & SETTERS

	public int getId_Almacenes() {
		return Id_Almacenes;
	}

	public void setId_Almacenes(int id_Almacenes) {
		Id_Almacenes = id_Almacenes;
	}

	public String getLatitud() {
		return Latitud;
	}

	public void setLatitud(String latitud) {
		Latitud = latitud;
	}

	public String getLongitud() {
		return Longitud;
	}

	public void setLongitud(String longitud) {
		Longitud = longitud;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public boolean isSelectedToRoute() {
		return selectedToRoute;
	}

	public void setSelectedToRoute(boolean selectedToRoute) {
		this.selectedToRoute = selectedToRoute;
	}

}

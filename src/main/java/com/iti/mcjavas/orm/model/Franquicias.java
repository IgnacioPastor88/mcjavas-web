package com.iti.mcjavas.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Franquicias")
public class Franquicias {

	@Id
	@GeneratedValue
	@Column(name = "Id_franquicia")
	private int Id_franquicia;
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
	
	
	// GETTERS & SETTERS
	
	public int getId_franquicia() {
		return Id_franquicia;
	}
	public void setId_franquicia(int id_franquicia) {
		Id_franquicia = id_franquicia;
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
	
	
	
	
	
	
}
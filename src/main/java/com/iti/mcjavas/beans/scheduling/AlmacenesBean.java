package com.iti.mcjavas.beans.scheduling;


import com.iti.mcjavas.orm.model.Almacenes;

public class AlmacenesBean {
	

	private int id_almacen;
	private String latitud;
	private String longitud;
	private String nombre;
	private String direccion;
	private String pais;

	
	public AlmacenesBean(Almacenes almacenes) {
		this.id_almacen = almacenes.getId_Almacenes();
		this.latitud = almacenes.getLatitud();
		this.longitud = almacenes.getLongitud();
		this.nombre = almacenes.getNombre();
		this.direccion = almacenes.getDireccion();
		this.pais = almacenes.getPais();
	}

	public Almacenes loadFranquicias() {
		Almacenes almacenes = new Almacenes();
		almacenes.setId_Almacenes(id_almacen);
		almacenes.setLatitud(latitud);
		almacenes.setLongitud(longitud);
		almacenes.setNombre(nombre);
		almacenes.setDireccion(direccion);
		almacenes.setPais(pais);
		return almacenes;
	}

	public int getId_almacen() {
		return id_almacen;
	}

	public void setId_almacen(int id_almacen) {
		this.id_almacen = id_almacen;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	

	// GETTERS & SETTERS
	
	

	
}
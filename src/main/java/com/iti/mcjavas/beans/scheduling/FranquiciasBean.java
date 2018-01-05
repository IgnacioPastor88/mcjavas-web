package com.iti.mcjavas.beans.scheduling;


import com.iti.mcjavas.orm.model.Franquicias;

public class FranquiciasBean {
	

	private int id_franquicia;
	private String latitud;
	private String longitud;
	private String nombre;
	private String direccion;
	private String pais;

	
	public FranquiciasBean(Franquicias franquicias) {
		this.id_franquicia = franquicias.getId_franquicia();
		this.latitud = franquicias.getLatitud();
		this.longitud = franquicias.getLongitud();
		this.nombre = franquicias.getNombre();
		this.direccion = franquicias.getDireccion();
		this.pais = franquicias.getPais();
	}

	public Franquicias loadFranquicias() {
		Franquicias franquicias = new Franquicias();
		franquicias.setId_franquicia(id_franquicia);
		franquicias.setLatitud(latitud);
		franquicias.setLongitud(longitud);
		franquicias.setNombre(nombre);
		franquicias.setDireccion(direccion);
		franquicias.setPais(pais);
		return franquicias;
	}
	

	

	// GETTERS & SETTERS

	public int getId_franquicia() {
		return id_franquicia;
	}

	public void setId_franquicia(int id_franquicia) {
		this.id_franquicia = id_franquicia;
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

	

	
}
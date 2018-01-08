package com.iti.mcjavas.beans.scheduling;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.iti.mcjavas.orm.model.Franquicias;

@ViewScoped
@ManagedBean(name = "franquiciasBean")
public class FranquiciasBean implements Serializable {
	private static final long serialVersionUID = 1895464451959165416L;

	private FranquiciasLogic franquiciasLogic = new FranquiciasLogic();
	private int id_franquicia;
	private String latitud;
	private String longitud;
	private String nombre;
	private String direccion;
	private String pais;

	private List<Franquicias> franquicias;
	private boolean alertNumberFranchises;
	private String alertMessageFranchises;

	public FranquiciasBean(Franquicias franquicias) {
		this.id_franquicia = franquicias.getId_franquicia();
		this.latitud = franquicias.getLatitud();
		this.longitud = franquicias.getLongitud();
		this.nombre = franquicias.getNombre();
		this.direccion = franquicias.getDireccion();
		this.pais = franquicias.getPais();
	}

	public FranquiciasBean() {

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

	public void init() {
		setFranquicias(franquiciasLogic.loadFranchises());
	}

	public void onload() {
		for (int i = 0; i < franquicias.size(); i++) {
			franquicias.get(i).setSelectedToRoute(false);

		}
		alertNumberFranchises = false;
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

	public List<Franquicias> getFranquicias() {
		return franquicias;
	}

	public void setFranquicias(List<Franquicias> franquicias) {
		this.franquicias = franquicias;
	}

	public boolean isAlertNumberFranchises() {
		return alertNumberFranchises;
	}

	public void setAlertNumberFranchises(boolean alertNumberFranchises) {
		this.alertNumberFranchises = alertNumberFranchises;
	}

	public String getAlertMessageFranchises() {
		return alertMessageFranchises;
	}

	public void setAlertMessageFranchises(String alertMessageFranchises) {
		this.alertMessageFranchises = alertMessageFranchises;
	}

	// LISTENERS
	public void changeListener() {

		int contSelectedCheckboxes = 0;
		for (int i = 0; i < franquicias.size(); i++) {
			if (franquicias.get(i).isSelectedToRoute() == true) {
				contSelectedCheckboxes++;
			}
		}

		if (contSelectedCheckboxes < 1) {
			alertMessageFranchises = "Debe seleccionar 1 franquicia";
			alertNumberFranchises = true;
		} else if (contSelectedCheckboxes > 9) {
			alertMessageFranchises = "No se permite seleccionar más de 9 franquicias";
			alertNumberFranchises = true;
		} else {
			alertNumberFranchises = false;
		}

	}

}

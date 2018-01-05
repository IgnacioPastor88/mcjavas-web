package com.iti.mcjavas.beans.scheduling;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class AdminFranquiciasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6900475820788829549L;


	private FranquiciasLogic franquiciasLogic = new FranquiciasLogic();

	
	private List<FranquiciasBean> franquiciasIngresados;
	private int IdFranquicia;
	private String lat;
	private String lon;
	private String nombre;
	private String dir;
	private String pais;

	public void init() {
		franquiciasIngresados = franquiciasLogic.loadfranquiciasBean();
	}
	
	public void agregaFranquicia(){
		franquiciasLogic.agregaFranquicias(lat, lon, nombre, dir, pais);
	}

	public List<FranquiciasBean> getFranquiciasIngresados() {
		return franquiciasIngresados;
	}

	// GETTERS & SETTERS
	
	public void setFranquiciasIngresados(List<FranquiciasBean> franquiciasIngresados) {
		this.franquiciasIngresados = franquiciasIngresados;
	}

	public int getIdFranquicia() {
		return IdFranquicia;
	}

	public void setIdFranquicia(int idFranquicia) {
		IdFranquicia = idFranquicia;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	

		
	


}

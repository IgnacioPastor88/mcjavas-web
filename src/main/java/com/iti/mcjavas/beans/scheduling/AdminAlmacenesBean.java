package com.iti.mcjavas.beans.scheduling;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class AdminAlmacenesBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6395055490961003132L;


	private AlmacenesLogic almacenesLogic = new AlmacenesLogic();

	
	private List<AlmacenesBean> almacenesIngresados;
	private int idAlmacen;
	private String lat;
	private String lon;
	private String nombre;
	private String dir;
	private String pais;

	public void init() {
		almacenesIngresados = almacenesLogic.loadalmacenesBean();
	}
	
	public void agregaAlmacen(){
		almacenesLogic.agregaAlmacenes(lat, lon, nombre, dir, pais);
	}

	public List<AlmacenesBean> getAlmacenesIngresados() {
		return almacenesIngresados;
	}

	public void setAlmacenesIngresados(List<AlmacenesBean> almacenesIngresados) {
		this.almacenesIngresados = almacenesIngresados;
	}

	
	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
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

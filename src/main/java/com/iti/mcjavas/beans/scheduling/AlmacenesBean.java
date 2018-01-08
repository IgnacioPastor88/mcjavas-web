package com.iti.mcjavas.beans.scheduling;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.iti.mcjavas.orm.model.Almacenes;

@ViewScoped
@ManagedBean(name = "almacenesBean")
public class AlmacenesBean implements Serializable {

	private AlmacenesLogic almacenesLogic = new AlmacenesLogic();
	private static final long serialVersionUID = 1895464451959165416L;

	private int id_almacen;
	private String latitud;
	private String longitud;
	private String nombre;
	private String direccion;
	private String pais;

	private List<Almacenes> almacenes;
	private boolean alertNumberWarehouses;
	private String alertMessage;

	public AlmacenesBean(Almacenes almacenes) {
		this.id_almacen = almacenes.getId_Almacenes();
		this.latitud = almacenes.getLatitud();
		this.longitud = almacenes.getLongitud();
		this.nombre = almacenes.getNombre();
		this.direccion = almacenes.getDireccion();
		this.pais = almacenes.getPais();
	}

	public AlmacenesBean() {

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

	public void init() {
		setAlmacenes(almacenesLogic.loadWarehouses());
	}

	public void onload() {
		for (int i = 0; i < almacenes.size(); i++) {
			almacenes.get(i).setSelectedToRoute(false);
		}
		alertNumberWarehouses = false;
	}

	public List<Almacenes> getAlmacenes() {
		return almacenes;
	}

	public void setAlmacenes(List<Almacenes> almacenes) {
		this.almacenes = almacenes;
	}

	public boolean isAlertNumberWarehouses() {
		return alertNumberWarehouses;
	}

	public void setAlertNumberWarehouses(boolean alertNumberWarehouses) {
		this.alertNumberWarehouses = alertNumberWarehouses;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	// LISTENERS
	public void changeListener() {

		int contSelectedCheckboxes = 0;
		for (int i = 0; i < almacenes.size(); i++) {
			if (almacenes.get(i).isSelectedToRoute() == true) {
				contSelectedCheckboxes++;
			}
		}
		if (contSelectedCheckboxes < 1) {
			alertMessage = "Debe seleccionar 1 almacen";
			alertNumberWarehouses = true;
		} else if (contSelectedCheckboxes > 1) {
			alertMessage = "No se permite seleccionar más de 1 almacen";
			alertNumberWarehouses = true;
		} else {
			alertNumberWarehouses = false;
		}

	}
}
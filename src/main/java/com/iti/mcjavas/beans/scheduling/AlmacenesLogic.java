package com.iti.mcjavas.beans.scheduling;

import java.util.ArrayList;
import java.util.List;

import com.iti.mcjavas.orm.dao.AlmacenesDao;
import com.iti.mcjavas.orm.model.Almacenes;

public class AlmacenesLogic {

	private AlmacenesDao almacenesDao = new AlmacenesDao();

	public void agregaAlmacenes (String latitud,String longitud,String nombre,String dir,String pais) {
		
		Almacenes fran = new Almacenes();
		fran.setLatitud(latitud);
		fran.setLongitud(longitud);
		fran.setNombre(nombre);
		fran.setDireccion(dir);
		fran.setPais(pais);
		almacenesDao.addUser(fran);
		
	}
	
	public List<AlmacenesBean> loadalmacenesBean() {
		List<AlmacenesBean> almacenesBean = new ArrayList<>();
		List<Almacenes> almacenes = almacenesDao.findAll();
		for (Almacenes almacen : almacenes) {
			almacenesBean.add(new AlmacenesBean(almacen));
		}
		return almacenesBean;
	}

}

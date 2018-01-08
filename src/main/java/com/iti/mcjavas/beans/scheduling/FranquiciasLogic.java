package com.iti.mcjavas.beans.scheduling;

import java.util.ArrayList;
import java.util.List;
import com.iti.mcjavas.orm.dao.FranquiciasDao;
import com.iti.mcjavas.orm.model.Franquicias;

public class FranquiciasLogic {

	private FranquiciasDao franquiciasDao = new FranquiciasDao();

	public void agregaFranquicias (String latitud,String longitud,String nombre,String dir,String pais) {
		
		Franquicias fran = new Franquicias();
		fran.setLatitud(latitud);
		fran.setLongitud(longitud);
		fran.setNombre(nombre);
		fran.setDireccion(dir);
		fran.setPais(pais);
		franquiciasDao.addUser(fran);
		
	}
	
	public List<FranquiciasBean> loadfranquiciasBean() {
		List<FranquiciasBean> franquiciasBean = new ArrayList<>();
		List<Franquicias> franquicias = franquiciasDao.findAll();
		for (Franquicias franquicia : franquicias) {
			franquiciasBean.add(new FranquiciasBean(franquicia));
		}
		if(!franquiciasBean.isEmpty()){
			System.out.println(franquiciasBean.get(0).getNombre()+"Lista");
		}

		return franquiciasBean;
	}

	public List<Franquicias> loadFranchises() {
		List<Franquicias> f = franquiciasDao.findAll();

		return f;
	}


}

package com.iti.mcjavas.beans.scheduling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iti.mcjavas.orm.dao.UsuariosDao;
import com.iti.mcjavas.orm.model.Freight;
import com.iti.mcjavas.orm.model.Usuarios;

public class UsuariosLogic {
	
	private UsuariosDao usuariosDao = new UsuariosDao();

	public void agregaUsuarios (String user,String password,String roles,String nombre,String email) {
		
		Usuarios usu = new Usuarios();
		usu.setUser(user);
		usu.setPassword(password);
		usu.setRoles(roles);
		usu.setNombre(nombre);
		usu.setEmail(email);
		System.out.println(usu);
		usuariosDao.addUser(usu);
		
	}
	
	public List<UsuariosBean> loadusuariosBean() {
		List<UsuariosBean> usuariosBean = new ArrayList<>();
		List<Usuarios> usuarios = usuariosDao.findAll();
		for (Usuarios usuario : usuarios) {
			usuariosBean.add(new UsuariosBean(usuario));
		}
		if(usuariosBean.size()>1){
			System.out.println(usuariosBean.get(1).getUser()+"Lista");
		}
		return usuariosBean;
	}

}

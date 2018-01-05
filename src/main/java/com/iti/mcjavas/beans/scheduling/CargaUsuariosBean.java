package com.iti.mcjavas.beans.scheduling;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class CargaUsuariosBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2379729176127812820L;

	private UsuariosLogic usuariosLogic = new UsuariosLogic();

	
	private List<UsuariosBean> usuariosIngresados;
	private int IdUsuario;
	private String userVar;
	private String passwordV;
	private String rolesV;
	private String nombreV;
	private String emailV;

	public void init() {
		usuariosIngresados = usuariosLogic.loadusuariosBean();
	}
	
	public void agregaUsuario(){
		System.out.println("usuarios"+userVar);
		usuariosLogic.agregaUsuarios(userVar, passwordV, rolesV, nombreV, emailV);
	}
	
	// GETTERS & SETTERS
	
	public List<UsuariosBean> getUsuariosIngresados() {
		return usuariosIngresados;
	}

	public void setUsuariosIngresados(List<UsuariosBean> usuariosIngresados) {
		this.usuariosIngresados = usuariosIngresados;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getUserVar() {
		return userVar;
	}

	public void setUserVar(String userVar) {
		this.userVar = userVar;
	}

	public String getPasswordV() {
		return passwordV;
	}

	public void setPasswordV(String passwordV) {
		this.passwordV = passwordV;
	}

	public String getRolesV() {
		return rolesV;
	}

	public void setRolesV(String rolesV) {
		this.rolesV = rolesV;
	}

	public String getNombreV() {
		return nombreV;
	}

	public void setNombreV(String nombreV) {
		this.nombreV = nombreV;
	}

	public String getEmailV() {
		return emailV;
	}

	public void setEmailV(String emailV) {
		this.emailV = emailV;
	}

	
	
	


}

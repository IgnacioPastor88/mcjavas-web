package com.iti.mcjavas.beans.scheduling;


import com.iti.mcjavas.orm.model.Usuarios;

public class UsuariosBean {
	

	private int idUsuario;
	private String user;
	private String password;
	private String roles;
	private String nombre;
	private String email;

	
	public UsuariosBean(Usuarios usuarios) {
		this.idUsuario = usuarios.getIdUsuario();
		this.user = usuarios.getUser();
		this.password = usuarios.getPassword();
		this.roles = usuarios.getRoles();
		this.nombre = usuarios.getNombre();
		this.email = usuarios.getEmail();
	}

	public Usuarios loadUsuarios() {
		Usuarios usuarios = new Usuarios();
		usuarios.setIdUsuario(idUsuario);
		usuarios.setUser(user);
		usuarios.setPassword(password);
		usuarios.setRoles(roles);
		usuarios.setNombre(nombre);
		usuarios.setEmail(email);
		return usuarios;
	}

	// GETTERS & SETTERS

	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	
}
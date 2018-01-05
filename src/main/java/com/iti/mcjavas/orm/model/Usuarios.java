package com.iti.mcjavas.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuarios {

	@Id
	@GeneratedValue
	@Column(name = "IdUsuario")
	private int IdUsuario;
	@Column(name = "User")
	private String User;
	@Column(name = "Password")
	private String Password;
	@Column(name = "Roles")
	private String Roles;
	@Column(name = "Nombre")
	private String Nombre;
	
	@Column(name = "Email")
	private String Email;

	// GETTERS & SETTERS
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRoles() {
		return Roles;
	}
	public void setRoles(String roles) {
		Roles = roles;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	
	
}
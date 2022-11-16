package com.guillermo.Dpt_1n;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class Empleado  implements Serializable{
	String hola;
	@Id					
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id_empleado")
	private int id_empleado;
	
	@Column(name="nombre")
	private String nombre;
	@ManyToOne
	@JoinColumn(name="id_empleado",referencedColumnName="id_departamento")
	private Departamento departamento;
	public Empleado() {}
	public Empleado(int id_empleado, String nombre, Departamento departamento) {
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.departamento = departamento;
	}
	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id_empleado+ ", nombre=" + nombre+ ", Departamento=" + departamento + "]";
	}
	
	
	
}

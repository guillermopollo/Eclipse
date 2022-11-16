package com.guillermo.Dpt_1n;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="departamentos")
public class Departamento {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id_departamento")
	private int id_departamento;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Empleado> empleados;
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Departamento() {}
	
	public Departamento(int id_departamento , String nombre) {
		super();
		this.id_departamento = id_departamento;
		this.nombre = nombre;
	}
	
	public int getId_departamento() {
		return id_departamento;
	}
	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	
}

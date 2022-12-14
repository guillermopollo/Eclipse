package com.juan.HibernateRelacion1aN;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que mapea un objeto Personaje con la tabla de MySQL correspondiente, utilizando anotaciones

 */
@Entity
@Table(name="personaje")
public class Personaje implements Serializable {

	@Id					// Marca el campo como la clave de la tabla
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id_personaje")  // Opcional si coinciden atributo y columna. 
						// Indica la columna de la tabla que corresponde con este atributo
	private int id_personaje;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="nivel")
	private int nivel;
	
	@Column(name="energia")
	private int energia;
	
	@Column(name="puntos")
	private int puntos;
	
	@ManyToOne
	@JoinColumn(name="id_arma",referencedColumnName="id_arma")
	private Arma arma;
	
	// Constructor vacío. Hibernate puede mostrar algún error si no está implementado
	public Personaje() {}
	
	public Personaje(int id_personaje, String nombre, int nivel, int energia, int puntos, Arma arma) {
		this.id_personaje = id_personaje;
		this.nombre = nombre;
		this.nivel = nivel;
		this.energia = energia;
		this.puntos = puntos;
		this.arma = arma;
	}
	
	
	public int getId() {
		return id_personaje;
	}
	
	public void setId(int id_personaje) {
		this.id_personaje = id_personaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int getEnergia() {
		return energia;
	}
	
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Arma getArma() {
		return arma;
	}
	

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	@Override
	public String toString() {
		return "Personaje [id=" + id_personaje + ", nombre=" + nombre + ", nivel=" + nivel + ", energia=" + energia + ", puntos="
				+ puntos + ", arma=" + arma + "]";
	}
	
	
}

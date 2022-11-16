package com.guillermo.Dpt_1n;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
 // SessionFactoryes una instancia que creará objetos de tipo Sessiono(fabrica
 		// sessiones).

 		SessionFactory factory = HibernateUtil.getSessionFactory();

 		// Ahora que ya tenemos el objeto SessionFactory podemos obtener la Session
 		// para trabajar con Hibernate.

 		// Una sesión se utiliza para obtener una conexión física con una base de datos.
 		// El objeto Session es liviano y está diseñado para ser instanciado
 		// cada vez que se necesita una interacción con la base de datos.
 		// Los objetos persistentes se guardan y recuperan a través de un objeto de
 		// sesión.

 		// Los objetos de la sesión no deben mantenerse abiertos durante mucho tiempo
 		// porque generalmente no son seguros para subprocesos y deben crearse y
 		// destruirse
 		// según sea necesario. La función principal de la sesión
 		// es ofrecer, crear, leer y eliminar operaciones para instancias
 		// de clases de entidades asignadas.

 		Session session = HibernateUtil.getSession();
 		//si os fijais en el constructor de la clase padre no esta a lista, es decir NO
 		//se utiliza para nada a la hora de insertar. Solo la utiliza para uso interno.
 		int numero= 12;
 		Departamento dep1 = new Departamento(numero,"departamento1");

 		session.beginTransaction();
 		session.save(dep1);
 		
 		session.getTransaction().commit();
 		// el resto de operaciones CRUD se haria como en el ejemplo anterior con una
 		// sola clase y tabla

 		//podriamos seleccionar un objeto de la clase padre de otra forma sin crearlo, es decir uno 
 		//que ya exista como por ejemplo el que tiene id=1
 		Departamento dep2=session.get(Departamento.class, 1);
 		
 		
 		//ahora insertamos un personaje, tener en cuenta que aqui si es necesario insertar un objeto del padre.
 		//de alguna de las 2 formas que os he exlicado antes.
 		Empleado empleado1 = new Empleado();
 		empleado1.setNombre("Mortadelo");
 		empleado1.setId_empleado(120);
 		empleado1.setDepartamento(dep1);

 		//personaje1.setArma(arma2);
 		session.beginTransaction();
 		session.save(empleado1);

 		session.getTransaction().commit();

 		// modificar
 		// 1 buscamos el personaje a modificar, suponemos que hemos introducido el 2

 		Empleado Empleado_aux = (Empleado) session.createQuery("FROM Personaje  WHERE id_personaje = 2").uniqueResult();

 		if (Empleado_aux != null) {
 			System.out.println(Empleado_aux.toString());
 			// modifico el campo nombre por poner un ejemplo
 			Empleado_aux.setNombre("Rodolfo");
 			session.beginTransaction();
 			session.update(Empleado_aux);
 			session.getTransaction().commit();
 		} else
 			System.out.println("Personaje NO ENCONTRADO");

 		// eliminar al peronaje id=4

 		Empleado_aux = (Empleado) session.createQuery("FROM Personaje  WHERE id_personaje = 4").uniqueResult();
 		session.beginTransaction();
 		session.delete(Empleado_aux);
 		session.getTransaction().commit();

 		// listar

 		List<Empleado> lista = session.createQuery("from Personaje").getResultList();

 		for (Empleado p : lista) {
 			// formato clasico
 			System.out.println(p.toString());

 		}

 		session.close();
}}

package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {
	//Crear Empleado
		public String createEmpleado(String apellido, String nombre, int edad, String sexo, double salario) {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				Empleado empleado = new Empleado(apellido, nombre, edad, sexo, salario);
				
				session.beginTransaction();
				session.save(empleado);
				session.getTransaction().commit();
				
				sessionFactory.close();
				
				return "Empleado creado";
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return "Error al crear empleado";
		}
		
	//Eliminar Empleado
		public String deleteEmpleado(int id) {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				
				session.beginTransaction();
				Empleado empleado = session.get(Empleado.class, id);
				session.delete(empleado);
				session.getTransaction().commit();
				
				sessionFactory.close();
				
				return "Eliminar empleado correctamente";
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return "Error al eliminar empleado";	
		}
		
	//Actualizar empleado
		public String updateEmpleado(int idempleado, String apellido, String nombre, int edad, String sexo, double salario) {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				
				session.beginTransaction();
				
				Empleado empleado = session.get(Empleado.class, idempleado);
				empleado.setApellido(apellido);
				empleado.setNombre(nombre);
				empleado.setEdad(edad);
				empleado.setSexo(sexo);
				empleado.setSalario(salario);
				session.update(empleado);
				session.getTransaction().commit();
				
				sessionFactory.close();
				
				return "Empleado actualizado correctamente";
				
			}catch (Exception e) {
				
				e.printStackTrace();
			
			}
			
			return "Error al actualizar Empleado";
			
		}
		
}

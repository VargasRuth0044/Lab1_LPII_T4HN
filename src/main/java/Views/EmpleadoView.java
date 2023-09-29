package Views;

import controllers.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {
		//Crear usuario
		//String empleado = new EmpleadoController().createEmpleado("Muñoz", "Emerejildo", 22, "Masculino", 1100);				
		//Eliminar usuario
		//String empleado = new EmpleadoController().deleteEmpleado(8);
				
		//Actualizar Usuario
		String empleado = new EmpleadoController().updateEmpleado(3,"Tirado", "Manula", 42, "Femenino", 1000.5);
				
		System.out.println(empleado);

	}

}

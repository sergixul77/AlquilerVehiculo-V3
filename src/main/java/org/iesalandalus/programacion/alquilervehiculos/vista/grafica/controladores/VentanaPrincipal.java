
package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class VentanaPrincipal extends Controlador {

	@FXML
	void leerCliente(ActionEvent event) {

		LeerCliente leerCliente = (LeerCliente) Controladores.get("vistas/LeerCliente.fxml", "Leer Cliente",
				getEscenario()); /* Leo la vista */
		leerCliente.limpiar();
		leerCliente.getEscenario().showAndWait();
		/* System.out.println(leerCliente.getCliente()); */
		try {
			Cliente cliente = leerCliente.getCliente(); /* Leo el cliente, puede lanzar excepcion */
			if (cliente != null) { /* Si es diferente de null lo inserta */
				VistaGrafica.getInstancia().getControlador().insertar(cliente);
				Dialogos.mostrarDialogoAdvertencia("Insertar Cliente", "Cliente insertado de forma correcta",
						getEscenario());
			}
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			Dialogos.mostrarDialogoError("Insertar Cliente", e.getMessage(), getEscenario());
		}

	}

	@FXML
	void listarClientes(ActionEvent event) {

		ListarClientes listarClientes = (ListarClientes) Controladores.get("vistas/ListarClientes.fxml",
				"Listar Clientes", getEscenario());

		listarClientes.actualizar(VistaGrafica.getInstancia().getControlador().getClientes());
		listarClientes.getEscenario().showAndWait();
	}

	@FXML
	void salir(ActionEvent event) {
		getEscenario().close();
	}

}

//package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;
//
//import java.util.List;
//
//import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
//import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
//import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//
//public class ListarClientes extends Controlador {
//
//	
//	
//	  @FXML
//	    private Button btBoton;
//
//	    @FXML
//	    private TableColumn<Cliente, String> tcDni;
//
//	    @FXML
//	    private TableColumn<Cliente, String> tcNombre;
//
//	    @FXML
//	    private TableColumn<Cliente, String> tcTelefono;
//
//	    @FXML
//	    private TableView<Cliente> tvClientes;
//
//	    @FXML
//	    private Font x1;
//
//	    @FXML
//	    private Color x2;
//
//	    @FXML
//	    private Font x3;
//
//	    @FXML
//	    private Color x4;
//
//	    @FXML
//	    void aceptar(ActionEvent event) {
//
//	    	getEscenario().close();
//	    	
//	    }
//	    @FXML
//	    void initialize() {
//			tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
//			
//			tcDni.setCellValueFactory (fila -> new SimpleStringProperty(fila.getValue().getDni()));
//			
//			tcTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
//			
//		}
//	    @FXML
//	    public void actualizar (List<Cliente> cliente) {
//	    	tvClientes.setItems(FXCollections.observableArrayList(cliente));
//	    	
//		}
//	    
//	    
//
//		@FXML
//
//		void modificarCliente() {
//
//			ModificarCliente modificarCliente = (ModificarCliente) Controladores.get("vistas/ModificarCliente.fxml",
//					"ModificarCliente", getEscenario());
//			modificarCliente.limpiar();
//			modificarCliente.getEscenario().showAndWait();
//
//		}
//	    
//	    
//	
//	}



package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ListarClientes  extends Controlador{

    @FXML
    private Button btBoton;

    @FXML
    private TableColumn<Cliente, String> tcDni;

    @FXML
    private TableColumn<Cliente, String> tcNombre;

    @FXML
    private TableColumn<Cliente, String> tcTelefono;

    @FXML
    private TableView<Cliente> tvClientes;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void aceptar(ActionEvent event) {

    	getEscenario().close();
    	
    }

    @FXML
    void modificar(ActionEvent event) {
    	
    	ModificarCliente modificarCliente = (ModificarCliente) Controladores.get("vistas/ModificarCliente.fxml",
			"ModificarCliente", getEscenario());
		//smodificarCliente.limpiar();
		modificarCliente.getEscenario().showAndWait();
		
		try {
//			Cliente modificar = modificarCliente.getClienteModificado(); /*preguntar mañana*/
			VistaGrafica.getInstancia().getControlador().modificar(modificarCliente.devolverCliente(), modificarCliente.devolverNombre(), modificarCliente.devolverTelefono());
			Dialogos.mostrarDialogoAdvertencia("Modificar Cliente", "Cliente modificado de forma correcta",
					getEscenario());
		} catch (Exception e) {
			Dialogos.mostrarDialogoError("Modificar cliente", e.getMessage(), getEscenario());
		}


    }
    
    @FXML
    void borrar(ActionEvent event) {
    	
    	BorrarCliente borrarCliente = (BorrarCliente) Controladores.get("vistas/BorrarCliente.fxml", "Borrar Cliente", getEscenario());
    	borrarCliente.limpiar();
    	borrarCliente.getEscenario().showAndWait();

    }

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
    void actualizarTabla(ActionEvent event) {
    	tvClientes.setItems(FXCollections.observableArrayList(VistaGrafica.getInstancia().getControlador().getClientes()));
//    	actualizar(VistaGrafica.getInstancia().getControlador().getClientes());

    	
    	// sergio
    }
    
    @FXML
    public void actualizar (List<Cliente> cliente) {
    	tvClientes.setItems(FXCollections.observableArrayList(cliente));
    }
    
    @FXML
    void initialize() {
		tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		
		tcDni.setCellValueFactory (fila -> new SimpleStringProperty(fila.getValue().getDni()));
		
		tcTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		
	}
    	

}





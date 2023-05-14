package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Principal  extends Controlador{
	
	


	    @FXML
	   public void acceder(ActionEvent event) {
	    	
	    	VentanaPrincipal principal = (VentanaPrincipal) Controladores.get("vistas/VentanaPrincipal.fxml", "Principal", getEscenario());
	    	principal.getEscenario().showAndWait();
	    }
	    
	    
	    void salir() {
	    	getEscenario().close();
	    }

	}


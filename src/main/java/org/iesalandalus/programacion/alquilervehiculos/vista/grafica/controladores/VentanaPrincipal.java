package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VentanaPrincipal  {
	
	
	 @FXML
	    private ResourceBundle resources;


	    @FXML
	    private Button btPulsame;

	    @FXML
	    void saludar(ActionEvent event) {
	    		System.out.println("Has pulsado el boton");
	    }

	    @FXML
	    void initialize() {
	        assert btPulsame != null : "fx:id=\"btPulsame\" was not injected: check your FXML file 'Ejemplo.fxml'.";

	    }
	
}

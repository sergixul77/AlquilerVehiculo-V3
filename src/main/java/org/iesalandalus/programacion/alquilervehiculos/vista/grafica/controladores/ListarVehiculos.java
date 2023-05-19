package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ListarVehiculos extends Controlador {
	

	 @FXML
	    private TableColumn<Vehiculo, String> tcCilindrada;

	    @FXML
	    private TableColumn<Vehiculo, String> tcMarca;

	    @FXML
	    private TableColumn<Vehiculo, String> tcMatricula;

	    @FXML
	    private TableColumn<Vehiculo, String> tcModelo;

	    @FXML
	    private TableColumn<Vehiculo, String> tcPlazas;

	    @FXML
	    private TableColumn<Vehiculo, String> tcPma;
	    
	    @FXML
		private TableView<Vehiculo> tvVehiculo;

	    @FXML
	    private Font x1;

	    @FXML
	    private Color x2;

	    @FXML
	    private Font x3;

	    @FXML
	    private Color x4;
	    
    
//	    @FXML
//		public void actualizar(List<Vehiculo> vehiculo) {
//			tvVehiculo.setItems(FXCollections.observableArrayList(vehiculo));
//		}
	    
	    @FXML
		void initialize() {
	    	tcMarca.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getMarca()));
	    	tcModelo.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getModelo()));
	    	tcMatricula.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getMatricula()));
			tcCilindrada.setCellValueFactory(new PropertyValueFactory<>("Cilindrada"));
			tcPlazas.setCellValueFactory(new PropertyValueFactory<>("Plazas"));
			tcPma.setCellValueFactory(new PropertyValueFactory<>("Pma"));
	    
	    }
	    
	    
	    
	    
	    @FXML
	    void salir(ActionEvent event) {
	    	getEscenario().close();

	    }
	    
	    @FXML
	    void acerca_de(ActionEvent event) {
			AcercaDe acercade = (AcercaDe) Controladores.get("vistas/Acercade.fxml", "Acerca de...", getEscenario());
			acercade.getEscenario().showAndWait();
	    }
    
    
    
    
    

}
	



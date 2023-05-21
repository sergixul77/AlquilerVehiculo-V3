package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ListarVehiculos extends Controlador {

	private static final String AUTOBUS = "Autobus";

	private static final String FURGONETA = "Furgoneta";

	private static final String TURISMO = "Turismo";

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

	@FXML
	private String formatearCilindrada(Vehiculo vehiculo) {
		return vehiculo instanceof Turismo turismo ? String.format("%s", turismo.getCilindrada()) : "";

	}

	@FXML
	private String formatearPlazas(Vehiculo vehiculo) {
		String plazas = "";
		if (vehiculo instanceof Autobus autobus) {
			plazas = String.format("%s", autobus.getPlazas());
		} else if (vehiculo instanceof Furgoneta furgoneta) {
			plazas = String.format("%s", furgoneta.getPlazas());
		}
		return plazas;
	}

	private String formatearPma(Vehiculo vehiculo) {
		return vehiculo instanceof Furgoneta furgoneta ? String.format("%s", furgoneta.getPma()) : "";
	}

	@FXML
	void initialize() {
		tcMarca.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getMarca()));
		tcModelo.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getModelo()));
		tcMatricula.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getMatricula()));
		tcCilindrada.setCellValueFactory(fila -> new SimpleStringProperty(formatearCilindrada(fila.getValue())));
		tcPlazas.setCellValueFactory(fila -> new SimpleStringProperty(formatearPlazas(fila.getValue())));
		tcPma.setCellValueFactory(fila -> new SimpleStringProperty(formatearPma(fila.getValue())));

	}

	@FXML
	public void actualizar(List<Vehiculo> vehiculos) {
		tvVehiculo.setItems(FXCollections.observableArrayList(vehiculos));
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

	@FXML
	void insertar_vehiculo(ActionEvent event) { /* Leer Vehiculo */
		LeerVehiculo insertarVehiculo = (LeerVehiculo) Controladores.get("vistas/LeerVehiculo.fxml",
				"Insertar Vehiculo", getEscenario());
		insertarVehiculo.limpiar();
		insertarVehiculo.getEscenario().showAndWait();
	}

	@FXML
	void borrar_vehiculo(ActionEvent event) {

		BorrarVehiculo borrarVehiculo = (BorrarVehiculo) Controladores.get("vistas/BorrarVehiculo.fxml",
				"Borrar Vehiculo", getEscenario());
		borrarVehiculo.limpiar();
		borrarVehiculo.getEscenario().showAndWait();

		try {
			Vehiculo vehiculo = borrarVehiculo.getVehiculo();
			if (vehiculo != null) {
				VistaGrafica.getInstancia().getControlador().borrar(vehiculo);
				tvVehiculo.getItems().remove(vehiculo);
				Dialogos.mostrarDialogoAdvertencia("Borrar Vehiculo", "Vehiculo borrado correctamente", getEscenario());
			}

		} catch (Exception e) {
			Dialogos.mostrarDialogoAdvertencia("Borrar Vehiculo ", e.getMessage(), getEscenario());
		}

	}
	
	
	@FXML
    void buscar_vehiculo(ActionEvent event) {
		BuscarVehiculo buscarVehiculo = (BuscarVehiculo) Controladores.get("vistas/BuscarVehiculo.fxml", "Buscar Vehiculo", getEscenario());
		buscarVehiculo.limpiar();
		buscarVehiculo.getEscenario().showAndWait();
    }

}

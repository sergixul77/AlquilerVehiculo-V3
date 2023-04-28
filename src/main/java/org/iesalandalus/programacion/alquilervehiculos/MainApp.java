package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;

//version 2

import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.FactoriaVista;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {

		Vista vista = FactoriaVista.GRAFICA.crear(); // Esto crea una nueva vista

		FactoriaFuenteDatos fuenteDatos = FactoriaFuenteDatos.FICHEROS; // obtengo una instancia de la factoria fuente
																		// de datos?

		Modelo modeloCascada = new ModeloCascada(fuenteDatos); // Creo una nueva fuente de datos donde voy a almacenar
																// datos?

		Controlador controlador = new Controlador(modeloCascada, vista);

		controlador.comenzar();

	}

}

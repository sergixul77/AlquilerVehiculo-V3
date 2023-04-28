package org.iesalandalus.programacion.alquilervehiculos.vista.grafica;

	import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.recursos.LocalizadorRecursos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

	public class LanzadorVentanaPrincipal extends Application {

		@Override
		public void start(Stage escenarioPrincipal) throws Exception {
			try {
				FXMLLoader cargadorVentanaPrincipal = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/Ejemplo.fxml"));
				Parent raiz = cargadorVentanaPrincipal.load();
			
				Scene escena = new Scene(raiz);
				escenarioPrincipal.setTitle("Vista Gráfica de Alquiler de Vehículos");
				escenarioPrincipal.setScene(escena);
				escenarioPrincipal.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void comenzar() {
			launch(LanzadorVentanaPrincipal.class);
		}
	}


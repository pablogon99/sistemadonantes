package controlador;
	



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import vista.controladoradonaciones;
import vista.controladoradonantes;
import vista.controladorafomulario;
import vista.controladorainformes;
import vista.controladorasangre;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;



public class Mainsangre extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("sistema de donantes");

			 // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Mainsangre.class.getResource("..\\vista\\UIinicio.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
          controladorasangre controller1 = loader.getController();
          controller1.setMnprincipal(this);
            primaryStage.show();
           } catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		launch(args);
		
	}
	public void irapantalladonantes () {
	
		 try {
	            FXMLLoader loader = new FXMLLoader(Mainsangre.class.getResource("../vista/UIdonante.fxml"));
	            AnchorPane ventanaDos = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Venta Dos");
	            /* Le decimos a la ventana quién es la ventana original */
	            ventana.initOwner(primaryStage);
	            Scene scene = new Scene(ventanaDos);
	            ventana.setScene(scene);

	            controladoradonantes controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);
	            controller2.setmnprincipal(this);

	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        }
	    }
	public void irapantalladonacion () {
		
		 try {
	            FXMLLoader loader = new FXMLLoader(Mainsangre.class.getResource("../vista/UIdonacion.fxml"));
	            AnchorPane ventanaDos = (AnchorPane) loader.load();
	            /* Creamos la segunda ventana como otro stage */
	            Stage ventana = new Stage();
	            ventana.setTitle("Venta Dos");
	            /* Le decimos a la ventana quién es la ventana original */
	            ventana.initOwner(primaryStage);
	            Scene scene = new Scene(ventanaDos);
	            ventana.setScene(scene);

	            controladoradonaciones controller2 = loader.getController();
	            controller2.setStagePrincipal(ventana);
	            controller2.setmnprincipal(this);

	            ventana.show();

	        } catch (Exception e) {
	            //tratar la excepción
	        }
	    }
	
	public void irapantallainformes () {
		
		
	}
}


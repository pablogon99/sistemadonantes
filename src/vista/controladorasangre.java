package vista;

import java.io.IOException;

import controlador.Mainsangre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class controladorasangre {
	
	
	@FXML
	private Button btndonante;
	@FXML
	private Button btndonacion;
	@FXML
	private Button btninformes;
	@FXML
	private Mainsangre mnprincipal;
	
	private Stage ventana;

public void iradonantes( ActionEvent Event) {
	
	this.mnprincipal.irapantalladonantes();
}
public void cerrarventana() {
	this.ventana.close();
}

public void setMnprincipal(Mainsangre mnprincipal) {
	this.mnprincipal = mnprincipal;
}
public void iradonaciones() {
System.out.println("donaciones");

}
public void irainformes() {
System.out.println("informes");

}


}
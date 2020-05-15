package vista;

import java.sql.SQLException;

import controlador.Mainsangre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import modelo.Testconexion;
import modelo.formulario;

public class controladorafomulario {

	@FXML
	private Button Volver;
	@FXML
	private Button GuardarCambios;
	@FXML
	private Button BorrarCambios;
	@FXML
	private TextField fechatxt;
	@FXML
	private TextField Num_formulariotxt;
	@FXML
	private ChoiceBox <String> cb1;
	@FXML
	private ChoiceBox <String> cb2;
	@FXML
	private ChoiceBox <String> cb3;
	@FXML
	private ChoiceBox <String> cb4;
	@FXML
	private ChoiceBox <String> cb5;
	@FXML
	private ChoiceBox <String> cb6;
	@FXML
	private ChoiceBox <String> cb7;
	@FXML
	private ChoiceBox <String> cb8;
	@FXML
	private ChoiceBox <String> cb9;
	@FXML
	private ChoiceBox <String> cb10;
	@FXML
	private ChoiceBox <String> cb11;
	@FXML
	private ChoiceBox <String> cb12;
	@FXML
	private ChoiceBox <String> cb13;
	@FXML
	private ChoiceBox <String> cb14;
	@FXML
	private ChoiceBox <String> cb15;
	@FXML
	private ChoiceBox <String> cb16;
	@FXML
	private ChoiceBox <String> cb17;
	@FXML
	private ChoiceBox <String> cb18;
	@FXML
	private ChoiceBox <String> cb19;
	@FXML
	private ChoiceBox <String> cb20;
	@FXML
	private ChoiceBox <String> cb21;
	@FXML
	private ChoiceBox <String> cb22;
	@FXML
	private ChoiceBox <String> cb23;
	@FXML
	private ChoiceBox <String> cb24;
	@FXML
	private ChoiceBox <String> cb25;
	@FXML
	private ChoiceBox <String> cb26;
	@FXML
	private ChoiceBox <String> cb27;
	@FXML
	private ChoiceBox <String> cb28;
	@FXML
	private ChoiceBox <String> cb29;
	@FXML
	private ChoiceBox <String> cb30;
	@FXML
	private ChoiceBox <String> cb31;
	@FXML
	private ChoiceBox <String> cb32;
	@FXML
	private ChoiceBox <String> cb33;
	@FXML
	private ChoiceBox <String> cb34;
	@FXML
	private ChoiceBox <String> cb35;
	
	private boolean edicion=false;
	  private int indiceEdicion=0;
	
	private ObservableList<String> sino =FXCollections.observableArrayList();
	Testconexion con;
	private ObservableList<formulario> datos1 = FXCollections.observableArrayList();
	private ObservableList<formulario> datos2 = FXCollections.observableArrayList();
	private Stage ventana;
	private Mainsangre mnprincipal;
	
	
	 
		public void closeWindow(){
			this.ventana.close();
		}

	
public void initialize () throws SQLException {
	
	con = new Testconexion();
	sino.add(0,"SI");
	sino.add(1, "NO");
	sino.add(2, "----");
	cb1.setItems(sino);
	cb2.setItems(sino);
	cb3.setItems(sino);
	cb4.setItems(sino);
	cb5.setItems(sino);
	cb6.setItems(sino);
	cb7.setItems(sino);
	cb8.setItems(sino);
	cb9.setItems(sino);
	cb10.setItems(sino);
	cb11.setItems(sino);
	cb11.setItems(sino);
	cb12.setItems(sino);
	cb13.setItems(sino);
	cb14.setItems(sino);
	cb15.setItems(sino);
	cb16.setItems(sino);
	cb17.setItems(sino);
	cb18.setItems(sino);
	cb19.setItems(sino);
	cb20.setItems(sino);
	cb21.setItems(sino);
	cb22.setItems(sino);
	cb23.setItems(sino);
	cb24.setItems(sino);
	cb25.setItems(sino);
	cb26.setItems(sino);
	cb27.setItems(sino);
	cb28.setItems(sino);
	cb29.setItems(sino);
	cb30.setItems(sino);
	cb31.setItems(sino);
	cb32.setItems(sino);
	cb33.setItems(sino);
	cb34.setItems(sino);
	cb35.setItems(sino);
	
	
	edicion = false;
	indiceEdicion = 0;
}
public void Guardardatos() throws SQLException{
	if(cb1.getSelectionModel().getSelectedItem().equals("NO") || cb3.getSelectionModel().getSelectedItem().equals("NO") || cb12.getSelectionModel().getSelectedItem().equals("SI") || cb14.getSelectionModel().getSelectedItem().equals("SI") || cb16.getSelectionModel().getSelectedItem().equals("SI") || cb17.getSelectionModel().getSelectedItem().equals("SI")  ){	
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error!!!");
		alert.setHeaderText("CON LOS CAMPOS INTRODUCIDOS SERIAS NO APTO");
		alert.setContentText("SE GUARDARAN LOS DATOS NO APTO!");
		alert.showAndWait();
	}
	if(Num_formulariotxt.getText().equals("")||cb1.getSelectionModel().getSelectedItem().equals("")  || cb2.getSelectionModel().getSelectedItem().equals("")  ||cb3.getSelectionModel().getSelectedItem().equals("")|| cb4.getSelectionModel().getSelectedItem().equals("") ||cb5.getSelectionModel().getSelectedItem().equals("") ||cb6.getSelectionModel().getSelectedItem().equals("") ||cb7.getSelectionModel().getSelectedItem().equals("") ||cb8.getSelectionModel().getSelectedItem().equals("") ||cb9.getSelectionModel().getSelectedItem().equals("") ||cb10.getValue().contains("") ||cb11.getSelectionModel().getSelectedItem().equals("") ||cb12.getSelectionModel().getSelectedItem().equals("") 
			|| cb13.getSelectionModel().getSelectedItem().equals("")|| cb14.getSelectionModel().getSelectedItem().equals("")|| cb15.getSelectionModel().getSelectedItem().equals("")|| cb16.getSelectionModel().getSelectedItem().equals("")|| cb17.getSelectionModel().getSelectedItem().equals("") || cb18.getSelectionModel().getSelectedItem().equals("") ||
			 cb19.getSelectionModel().getSelectedItem().equals("") || cb20.getSelectionModel().getSelectedItem().equals("") || cb21.getSelectionModel().getSelectedItem().equals("") || cb22.getSelectionModel().getSelectedItem().equals("") || cb23.getSelectionModel().getSelectedItem().equals("") || cb24.getSelectionModel().getSelectedItem().equals("") || cb25.getSelectionModel().getSelectedItem().equals("") ||
			 cb26.getSelectionModel().getSelectedItem().equals("") || cb27.getSelectionModel().getSelectedItem().equals("")|| cb28.getSelectionModel().getSelectedItem().equals("") || cb29.getSelectionModel().getSelectedItem().equals("") || cb30.getSelectionModel().getSelectedItem().equals("") || cb31.getSelectionModel().getSelectedItem().equals("") ||
			 cb32.getSelectionModel().getSelectedItem().equals("") || cb33.getSelectionModel().getSelectedItem().equals("") || cb34.getSelectionModel().getSelectedItem().equals("") || cb35.getSelectionModel().getSelectedItem().equals("")||fechatxt.getText().contains("")){	
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error!!!");
		alert.setHeaderText("HAS RELLENADO TODOS LOS CAMPOS");
		alert.setContentText("Hacemos insercion");
		alert.showAndWait();
		
		formulario nuevoFormulario = new formulario(Integer.parseInt(Num_formulariotxt.getText()),cb1.getValue(),cb2.getValue(),cb3.getValue(),cb4.getValue(),cb5.getValue()
				,cb6.getValue(),cb7.getValue(),cb8.getValue(),cb9.getValue(),cb10.getValue(),cb11.getValue(),cb12.getValue(),cb13.getValue(),cb14.getValue()
				,cb15.getValue(),cb16.getValue(),cb17.getValue(),cb18.getValue(),cb19.getValue(),cb20.getValue(),cb21.getValue(),cb22.getValue(),cb23.getValue()
				,cb24.getValue(),cb25.getValue(),cb26.getValue(),cb27.getValue(),cb28.getValue(),cb29.getValue(),cb30.getValue(),cb31.getValue(),cb32.getValue()
				,cb33.getValue(),cb34.getValue(),cb35.getValue(),fechatxt.getText());
		datos1.add(nuevoFormulario);
		
		
			con.GuardarFormulario(Integer.parseInt(Num_formulariotxt.getText()),cb1.getSelectionModel().getSelectedItem().toString(),cb2.getSelectionModel().getSelectedItem().toString(),cb3.getSelectionModel().getSelectedItem().toString(),cb4.getSelectionModel().getSelectedItem().toString(),cb5.getSelectionModel().getSelectedItem().toString()
					,cb6.getSelectionModel().getSelectedItem().toString(),cb7.getSelectionModel().getSelectedItem().toString(),cb8.getSelectionModel().getSelectedItem().toString(),cb9.getSelectionModel().getSelectedItem().toString(),cb10.getSelectionModel().getSelectedItem().toString(),cb11.getSelectionModel().getSelectedItem().toString(),cb12.getSelectionModel().getSelectedItem().toString(),cb13.getSelectionModel().getSelectedItem().toString(),cb14.getSelectionModel().getSelectedItem().toString()
					,cb15.getSelectionModel().getSelectedItem().toString(),cb16.getSelectionModel().getSelectedItem().toString(),cb17.getSelectionModel().getSelectedItem().toString(),cb18.getSelectionModel().getSelectedItem().toString(),cb19.getSelectionModel().getSelectedItem().toString(),cb20.getSelectionModel().getSelectedItem().toString(),cb21.getSelectionModel().getSelectedItem().toString(),cb22.getSelectionModel().getSelectedItem().toString(),cb23.getSelectionModel().getSelectedItem().toString()
					,cb24.getSelectionModel().getSelectedItem().toString(),cb25.getSelectionModel().getSelectedItem().toString(),cb26.getSelectionModel().getSelectedItem().toString(),cb27.getSelectionModel().getSelectedItem().toString(),cb28.getSelectionModel().getSelectedItem().toString(),cb29.getSelectionModel().getSelectedItem().toString(),cb30.getSelectionModel().getSelectedItem().toString(),cb31.getValue().toString(),cb32.getSelectionModel().getSelectedItem().toString()
					,cb33.getSelectionModel().getSelectedItem().toString(),cb34.getSelectionModel().getSelectedItem().toString(),cb35.getSelectionModel().getSelectedItem().toString(),fechatxt.getText());
			Alert alerta = new Alert ( AlertType.INFORMATION ); 
		   	alerta . setTitle ( "Información " ); 
		   	alerta . setHeaderText (null); 
		   	alerta . setContentText ("¡FORMULARIO GUARDADO!");  
		   	alerta . showAndWait();
	}else {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error!!!");
		alert.setHeaderText("NO HAS RELLENADO TODOS LOS CAMPOS");
		alert.setContentText("RELLENALOS");
		alert.showAndWait();
	}
		
		}
	
	

	
	
	
	




public void Borrardatos() {
	cb1.setValue("----");
	cb2.setValue("----");
	cb3.setValue("----");
	cb4.setValue("----");
	cb5.setValue("----");
	cb6.setValue("----");
	cb7.setValue("----");
	cb8.setValue("----");
	cb9.setValue("----");
	cb10.setValue("----");
	cb11.setValue("----");
	cb12.setValue("----");
	cb13.setValue("----");
	cb14.setValue("----");
	cb15.setValue("----");
	cb16.setValue("----");
	cb17.setValue("----");
	cb18.setValue("----");
	cb19.setValue("----");
	cb20.setValue("----");
	cb21.setValue("----");
	cb22.setValue("----");
	cb23.setValue("----");
	cb24.setValue("----");
	cb25.setValue("----");
	cb26.setValue("----");
	cb27.setValue("----");
	cb28.setValue("----");
	cb29.setValue("----");
	cb30.setValue("----");
	cb31.setValue("----");
	cb32.setValue("----");
	cb33.setValue("----");
	cb34.setValue("----");
	cb35.setValue("----");
	
	edicion = false;
	indiceEdicion = 0;
}


}


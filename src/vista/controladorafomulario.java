package vista;

import java.sql.SQLException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class controladorafomulario {

	@FXML
	private Button Volver;
	@FXML
	private Button GuardarCambios;
	@FXML
	private Button BorrarCambios;
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
	
	
	
	private ObservableList<String> sino =FXCollections.observableArrayList();
	
	
public void initialize () throws SQLException {
	sino.add(0,"SI");
	sino.add(1, "NO");
	
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
	
}
public void Guardardatos() {
	
}
public void Borrardatos() {
	
}
public void Volver() {
	
}
}


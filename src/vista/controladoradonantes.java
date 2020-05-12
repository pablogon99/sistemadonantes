package vista;


import java.sql.SQLException;
import java.util.Optional;


import controlador.Mainsangre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Testconexion;
import modelo.donante;

public class controladoradonantes {
	@FXML
	private Button btnVolverdonantes;
	@FXML
	private Button btnElminardonantes;
	@FXML
	private Button btnGuardardonante;
	@FXML
	private Button btnBorrardonante;
	@FXML
	private Button btnEditardonante;
	
	@FXML
	private TextField N_donantetxt;
	@FXML
	private TextField Identificaciontxt;
	@FXML
	private TextField Nombretxt;
	@FXML
	private TextField Apellido1txt;
	@FXML
	private TextField Apellido2txt;
	@FXML
	private TextField Emailtxt;
	@FXML
	private TextField Estadotxt;
	@FXML
	private TextField Telefonotxt;
	@FXML
	private TextField Cod_postaltxt;
	@FXML
	private TextField Sexotxt;
	
	@FXML
	private TextField Grupo_sanguineotxt;
	@FXML
	private TextField Ciclotxt;
	
	@FXML
	private TableView<donante> tabla;

	@FXML
	private TableColumn<donante,Integer> colN_donante;

	@FXML
	private TableColumn<donante,String> colIdentificacion;

	@FXML
	private TableColumn<donante,String> colNombre;

	@FXML
	private TableColumn<donante,String> colApellido1;

	@FXML
	private TableColumn<donante,String> colApellido2;
	@FXML
	private TableColumn<donante,String> colEmail;
	@FXML
	private TableColumn<donante,String> colEstado;
	@FXML
	private TableColumn<donante,Integer> colTelefono;
	@FXML
	private TableColumn<donante,Integer> colCod_postal;
	@FXML
	private TableColumn<donante,String> colSexo;
	@FXML
	private TableColumn<donante,String> colGrupo_sanguineo;
	@FXML
	private TableColumn<donante,String> colCiclo;
	
	Testconexion con;
	private ObservableList<donante> datos1 = FXCollections.observableArrayList();
	private ObservableList<donante> datos2 = FXCollections.observableArrayList();
	private Stage ventana;
	private Mainsangre mnprincipal;

	
	 private boolean edicion=false;
	   private int indiceEdicion=0;
	
	public void setmnprincipal(Mainsangre mnprincipal) {
		this.mnprincipal=mnprincipal;
	}
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}

	public void closeWindow(){
		this.ventana.close();
	}

	public void initialize() throws SQLException{
		
		con = new Testconexion();
		datos1=con.MostrarTablaDonante();
		tabla.setItems(this.datos1);
		
		colN_donante.setCellValueFactory(new PropertyValueFactory<donante,Integer>("N_DONANTE"));
		colIdentificacion.setCellValueFactory(new PropertyValueFactory<donante,String>("IDENTIFICACION"));
		colNombre.setCellValueFactory(new PropertyValueFactory<donante,String>("NOMBRE"));
		colApellido1.setCellValueFactory(new PropertyValueFactory<donante,String>("APELLIDO1"));
		colApellido2.setCellValueFactory(new PropertyValueFactory<donante,String>("APELLIDO2"));
		colEmail.setCellValueFactory(new PropertyValueFactory<donante,String>("EMAIL"));
		colEstado.setCellValueFactory(new PropertyValueFactory<donante,String>("ESTADO"));
		colTelefono.setCellValueFactory(new PropertyValueFactory<donante,Integer>("TELEFONO"));
		colCod_postal.setCellValueFactory(new PropertyValueFactory<donante,Integer>("COD_POSTAL"));
		colSexo.setCellValueFactory(new PropertyValueFactory<donante,String>("SEXO"));
		colGrupo_sanguineo.setCellValueFactory(new PropertyValueFactory<donante,String>("GRUPO_SANGUINEO"));
		colCiclo.setCellValueFactory(new PropertyValueFactory<donante,String>("CICLO"));
	}
	
	public void GuardarDonante() throws SQLException {
		if(N_donantetxt.getText().equals("") || Nombretxt.getText().equals("") || Identificaciontxt.getText().equals("")|| Apellido1txt.getText().equals("")|| Apellido2txt.getText().equals("")|| Emailtxt.getText().equals("")|| Ciclotxt.getText().equals("")|| Grupo_sanguineotxt.getText().equals("")|| Estadotxt.getText().equals("")|| Telefonotxt.getText().equals("")|| Cod_postaltxt.getText().equals("")){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("Comprueba que has introducido todos los datos");
			alert.setContentText("¡Tienen que estar todos los campos para guardarlos!");
			alert.showAndWait();
		}else{

			donante nuevoDonante = new donante(	Integer.parseInt(N_donantetxt.getText()) ,Identificaciontxt.getText(),Nombretxt.getText(),Apellido1txt.getText(),Apellido2txt.getText(),Emailtxt.getText(),Estadotxt.getText(),	Integer.parseInt(Telefonotxt.getText()),Integer.parseInt(Cod_postaltxt.getText()),Sexotxt.getText(),Grupo_sanguineotxt.getText(),Ciclotxt.getText());
			datos1.add(nuevoDonante);
			
			if(edicion == true){
				donante editada  = datos1.get(indiceEdicion);
				editada.setN_DONANTE(Integer.parseInt(N_donantetxt.getText()));
				editada.setIDENTIFICACION(Identificaciontxt.getText());
				editada.setNOMBRE(Nombretxt.getText());;
				editada.setAPELLIDO1(Apellido1txt.getText());
				editada.setAPELLIDO2(Apellido2txt.getText());
				editada.setEMAIL(Emailtxt.getText());
				editada.setESTADO(Estadotxt.getText());
				editada.setTELEFONO(Integer.parseInt(Telefonotxt.getText()));
				editada.setCOD_POSTAL(Integer.parseInt(Cod_postaltxt.getText()));
				editada.setSEXO(Sexotxt.getText());
				editada.setGRUPO_SANGUINEO(Grupo_sanguineotxt.getText());
				editada.setCICLO(Ciclotxt.getText());
				
				datos1.set(indiceEdicion, editada);
				con.ActualizarDatos(datos1.get(0), editada);
				datos1=con.MostrarTablaDonante();
				tabla.setItems(datos1);
				
			if (edicion== false) {
				Alert alerta = new Alert ( AlertType.INFORMATION ); 
			   	alerta . setTitle ( "Información ERROR" ); 
			   	alerta . setHeaderText (null); 
			   	alerta . setContentText ("NO SE GUARDA EL DONANTE");  
			   	alerta . showAndWait();
			}else {
				Alert alerta = new Alert ( AlertType.INFORMATION ); 
			   	alerta . setTitle ( "Información " ); 
			   	alerta . setHeaderText (null); 
			   	alerta . setContentText ("DONANTE EDITADO");  
			   	alerta . showAndWait();
			}	
				
	
			}else {
				con.GuardarDonantes(Integer.parseInt(N_donantetxt.getText()) ,Identificaciontxt.getText(),Nombretxt.getText(),Apellido1txt.getText(),Apellido2txt.getText(),Emailtxt.getText(),Estadotxt.getText(),	Integer.parseInt(Telefonotxt.getText()),Integer.parseInt(Cod_postaltxt.getText()),Sexotxt.getText(),Grupo_sanguineotxt.getText(),Ciclotxt.getText());
				Alert alerta = new Alert ( AlertType.INFORMATION ); 
			   	alerta . setTitle ( "Información " ); 
			   	alerta . setHeaderText (null); 
			   	alerta . setContentText ("¡donante guardado!");  
			   	alerta . showAndWait();
			}
		}
		
	}
	public void BorrarDatos() {
		N_donantetxt.setText("");
		Identificaciontxt.setText("");
		Nombretxt.setText("");
		Apellido1txt.setText("");
		Apellido2txt.setText("");
		Emailtxt.setText("");
		Estadotxt.setText("");
		Telefonotxt.setText("");
		Cod_postaltxt.setText("");
		Sexotxt.setText("");
		Grupo_sanguineotxt.setText("");
		Ciclotxt.setText("");
		

		edicion = false;
		indiceEdicion = 0;
	}
	public void EditararDonante() {
	
		
		
		int index = tabla.getSelectionModel().getSelectedIndex();

		
		if( index >= 0){

			
			edicion = true;
			indiceEdicion = index;


			donante seleccionada = tabla.getSelectionModel().getSelectedItem();

			int N_donante=seleccionada.getN_DONANTE();
			int Telefono=seleccionada.getTELEFONO();
			int Cod_postal=seleccionada.getCOD_POSTAL();
			
			N_donantetxt.setText(""+N_donante+"");
			Identificaciontxt.setText(seleccionada.getIDENTIFICACION());
			Nombretxt.setText(seleccionada.getNOMBRE());
			Apellido1txt.setText(seleccionada.getAPELLIDO1());
			Apellido2txt.setText(seleccionada.getAPELLIDO2());
			Emailtxt.setText(seleccionada.getEMAIL());
			Estadotxt.setText(seleccionada.getESTADO());
			Telefonotxt.setText(""+Telefono+"");
			Cod_postaltxt.setText(""+Cod_postal+"");
			Sexotxt.setText(seleccionada.getSEXO());
			Grupo_sanguineotxt.setText(seleccionada.getGRUPO_SANGUINEO());
			Ciclotxt.setText(seleccionada.getCICLO());
	}
	
	}
	public void EliminarDonante(ActionEvent event) throws SQLException {
		int index = tabla.getSelectionModel().getSelectedIndex();

		if(index>=0){
			
			donante seleccionada = tabla.getSelectionModel().getSelectedItem();

					Alert alert = new Alert(AlertType.CONFIRMATION);
			       alert.setTitle("Borrando...");
			       alert.setHeaderText("Desea Borrar a " + seleccionada.getNOMBRE() +" "+ seleccionada.getAPELLIDO1());
			      
			       Optional <ButtonType> result = alert.showAndWait ();
			       
			      if (result.get () == ButtonType.OK){
			    	  
			    	  	con.Borrardonante(seleccionada.getN_DONANTE());
			    	   	datos1.remove(seleccionada);
						
			    	   	Alert alerta = new Alert ( AlertType.INFORMATION ); 
			    	   	alerta . setTitle ( "Información" ); 
			    	   	alerta . setHeaderText (null); 
			    	   	alerta . setContentText ( "¡Eliminado!" );  
			    	   	alerta . showAndWait (); 	
			       }
		}else{
			
				Alert alert = new Alert(AlertType.ERROR);
		       alert.setTitle("Error !");
		       alert.setHeaderText("Seleccione una fila...");
		       alert.showAndWait();
		}
		
		
		
		
	}
}



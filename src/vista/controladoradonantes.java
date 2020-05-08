package vista;


import java.sql.SQLException;

import controlador.Mainsangre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Testconexion;
import modelo.donante;

public class controladoradonantes {
	@FXML
	private Button btnVolverdonantes;
	@FXML
	private Button btnGuardardonante;
	@FXML
	private Button btnBorrardonante;
	@FXML
	private Button btnEditardonante;
	@FXML
	private Button btniraformulario;
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
	
	private Stage ventana;
	private Mainsangre mnprincipal;

	
	
	
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
		
		colN_donante.setCellValueFactory(new PropertyValueFactory<donante,Integer>("N_donante"));
		colIdentificacion.setCellValueFactory(new PropertyValueFactory<donante,String>("Identificacion"));
		colNombre.setCellValueFactory(new PropertyValueFactory<donante,String>("Nombre"));
		colApellido1.setCellValueFactory(new PropertyValueFactory<donante,String>("Apellido1"));
		colApellido2.setCellValueFactory(new PropertyValueFactory<donante,String>("Apellido2"));
		colEmail.setCellValueFactory(new PropertyValueFactory<donante,String>("Email"));
		colEstado.setCellValueFactory(new PropertyValueFactory<donante,String>("Estado"));
		colTelefono.setCellValueFactory(new PropertyValueFactory<donante,Integer>("Telefono"));
		colCod_postal.setCellValueFactory(new PropertyValueFactory<donante,Integer>("Cod_postal"));
		colSexo.setCellValueFactory(new PropertyValueFactory<donante,String>("Sexo"));
		colGrupo_sanguineo.setCellValueFactory(new PropertyValueFactory<donante,String>("Grupo_sanguineo"));
		colCiclo.setCellValueFactory(new PropertyValueFactory<donante,String>("Ciclo"));
	}
	
	public void GuardarDonante() {
		
	}
	public void BorrarDonante() {
		
	}
	public void EditararDonante() {
	
}
	public void IraFormulario() {
		
	}
	public void Volvermenu() {
		
	}
}



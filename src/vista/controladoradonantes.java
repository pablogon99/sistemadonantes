package vista;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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



package vista;

import controlador.Mainsangre;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modelo.donante;

public class controladorainformes {
	@FXML
	private Button btnVolverInformes;
	@FXML
	private Button btnConsultaAposi;
	@FXML
	private Button btnConsultaAnega;
	@FXML
	private Button btnConsultaCero;
	@FXML
	private Button btnConsultaCiclo;
	
	@FXML
	private TableView<donante> tabla;

	@FXML
	private TableColumn<donante,Integer> colN_donante;

	@FXML
	private TableColumn<donante,String> colNombre;

	@FXML
	private TableColumn<donante,String> colApellido1;

	@FXML
	private TableColumn<donante,String> colApellido2;
	@FXML
	private TableColumn<donante,String> colIdentificacion;
	@FXML
	private TableColumn<donante,String> colGrupo_sanguineo;
	@FXML
	private TableColumn<donante,String> colCiclo;
	@FXML
	private TableColumn<donante,String> colSexo;
	@FXML
	private TableColumn<donante,String> colEmail;
	
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
	
	
	public static void ConsultaAposi() {
		
	}
	public static void ConsultaAnega() {
		
	}

	public static void Consultaceroposi() {
	
	}
	public static void Consultaciclo() {
	
	}
	public static void Volvermenu() {
		
	}
}

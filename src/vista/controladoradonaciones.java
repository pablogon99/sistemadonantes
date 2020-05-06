package vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import modelo.donaciones;
import modelo.donante;

public class controladoradonaciones {

	@FXML
	private Button btnGuardardonacion;
	@FXML
	private Button btnVolverdonacion;
	@FXML
	private Button btnBorrardonacion;
	@FXML
	private TextField Num_donaciontxt;
	@FXML
	private TextField Fechatxt;
	@FXML
	private TextField Tipo_donaciontxt;
	@FXML
	private TextField Pulsotxt;
	@FXML
	private TextField Ta_sisttxt;
	@FXML
	private TextField Ta_diastxt;
	@FXML
	private TextField Hb_captxt;
	@FXML
	private TextField Hb_ventxt;
	
	@FXML
	private TableView<donaciones> tabla;

	@FXML
	private TableColumn<donaciones,Integer> colNum_donacion;
	@FXML
	private TableColumn<donaciones,String> colFecha;
	@FXML
	private TableColumn<donaciones,String> colTipo_donacion;
	@FXML
	private TableColumn<donaciones,String> colPulso;
	@FXML
	private TableColumn<donaciones,String> colTa_sist;
	@FXML
	private TableColumn<donaciones,String> colTa_dias;
	@FXML
	private TableColumn<donaciones,String> colHb_cap;
	@FXML
	private TableColumn<donaciones,String> colHb_ven;
	
	
	
	
	
	
	public void GuardarDonacion() {
		
	}
	public void BorrarDonacion() {
		
	}
	public void Volvermenu() {
		
	}
}



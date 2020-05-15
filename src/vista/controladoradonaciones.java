package vista;

import java.sql.SQLException;

import controlador.Mainsangre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Testconexion;
import modelo.donaciones;


public class controladoradonaciones {
	@FXML
	private Button btniraformulario;
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
	
	
	Testconexion con;
	private ObservableList<donaciones> datos1 = FXCollections.observableArrayList();
	private ObservableList<donaciones> datos2 = FXCollections.observableArrayList();
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
	
	
public void initialize() throws SQLException{
		
		con = new Testconexion();
		datos1=con.MostrarTablaDonacion();
		tabla.setItems(this.datos1);
		
		colNum_donacion.setCellValueFactory(new PropertyValueFactory<donaciones,Integer>("NUM_DONACION"));
		colFecha.setCellValueFactory(new PropertyValueFactory<donaciones,String>("FECHA"));
		colTipo_donacion.setCellValueFactory(new PropertyValueFactory<donaciones,String>("TIPO_DONACION"));
		colPulso.setCellValueFactory(new PropertyValueFactory<donaciones,String>("PULSO"));
		colTa_sist.setCellValueFactory(new PropertyValueFactory<donaciones,String>("TA_SIST"));
		colTa_dias.setCellValueFactory(new PropertyValueFactory<donaciones,String>("TA_DIAS"));
		colHb_cap.setCellValueFactory(new PropertyValueFactory<donaciones,String>("HB_CAP"));
		colHb_ven.setCellValueFactory(new PropertyValueFactory<donaciones,String>("HB_VEN"));
		
	}
	
	public void closeWindow(){
		this.ventana.close();
	}

	
	
	
	public void GuardarDonacion() throws SQLException {
		if(Num_donaciontxt.getText().equals("") || Fechatxt.getText().equals("") || Tipo_donaciontxt.getText().equals("")|| Pulsotxt.getText().equals("")|| Ta_sisttxt.getText().equals("")|| Ta_diastxt.getText().equals("")|| Hb_captxt.getText().equals("")|| Hb_ventxt.getText().equals("")){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("Comprueba que has introducido todos los datos");
			alert.setContentText("¡Tienen que estar todos los campos para guardarlos!");
			alert.showAndWait();
		}else{

			donaciones nuevoDonante = new donaciones(	Integer.parseInt(Num_donaciontxt.getText()) ,Fechatxt.getText(),Tipo_donaciontxt.getText(),Pulsotxt.getText(),Ta_sisttxt.getText(),Ta_diastxt.getText(),Hb_captxt.getText(),Hb_ventxt.getText());
			datos1.add(nuevoDonante);
			
			if(edicion == true){
				donaciones editada  = datos1.get(indiceEdicion);
				editada.setNUM_DONACION(Integer.parseInt(Num_donaciontxt.getText()));
				editada.setFECHA(Fechatxt.getText());
				editada.setTIPO_DONACION(Tipo_donaciontxt.getText());;
				editada.setPULSO(Pulsotxt.getText());
				editada.setTA_SIST(Ta_sisttxt.getText());
				editada.setTA_DIAS(Ta_diastxt.getText());
				editada.setHB_CAP(Hb_captxt.getText());
				editada.setHB_VEN(Hb_ventxt.getText());
			
				
				datos1.set(indiceEdicion, editada);
				con.ActualizarDatosDonaciones(datos1.get(0), editada);
				datos1=con.MostrarTablaDonacion();
				tabla.setItems(datos1);
				
			if (edicion== false) {
				Alert alerta = new Alert ( AlertType.INFORMATION ); 
			   	alerta . setTitle ( "Información ERROR" ); 
			   	alerta . setHeaderText (null); 
			   	alerta . setContentText ("NO SE GUARDA LA DONACION");  
			   	alerta . showAndWait();
			}else {
				Alert alerta = new Alert ( AlertType.INFORMATION ); 
			   	alerta . setTitle ( "Información " ); 
			   	alerta . setHeaderText (null); 
			   	alerta . setContentText ("DONACION EDITADA");  
			   	alerta . showAndWait();
			}	
				
	
			}else {
				con.GuardarDonaciones(Integer.parseInt(Num_donaciontxt.getText()) ,Fechatxt.getText(),Tipo_donaciontxt.getText(),Pulsotxt.getText(),Ta_sisttxt.getText(),Ta_diastxt.getText(),Hb_captxt.getText(),Hb_ventxt.getText());
				Alert alerta = new Alert ( AlertType.INFORMATION ); 
			   	alerta . setTitle ( "Información " ); 
			   	alerta . setHeaderText (null); 
			   	alerta . setContentText ("¡donante guardado!");  
			   	alerta . showAndWait();
			}
		}
	}
	public void BorrarDonacion() {
		Num_donaciontxt.setText("");
		Fechatxt.setText("");
		Tipo_donaciontxt.setText("");
		Pulsotxt.setText("");
		Ta_sisttxt.setText("");
		Ta_diastxt.setText("");
		Hb_captxt.setText("");
		Hb_ventxt.setText("");
		
		

		edicion = false;
		indiceEdicion = 0;
	}
	
	public void IrAFormulario() {
		try{   
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("UIformulario.fxml"));         
			Parent root1= (Parent)fxmlLoader.load();                          
			//Creo un Stage, que es como una ventana vacia           
			Stage stage= new Stage();                          
			//Y ahora dentro del Stage meto la vista de informes  
			stage.setScene(new Scene(root1));                         
			// Y ahora le digo que me muestre el stage            
			stage.show();                     
			}catch(Exception e) {          
				e.printStackTrace();         }
		}

	}




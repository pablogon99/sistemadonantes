package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Testconexion {


	private String user= "";
	private String url= "";
	private String usr = "";
	private String pwd = "";
	private Connection conexion;
	

	public Testconexion()  {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/modelo/datos.ini");
			if (miFichero.exists()){
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("url");
				user=propiedades.getProperty("user");
				pwd=propiedades.getProperty("pwd");
				usr=propiedades.getProperty("usr");
			}

			else
				System.out.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);

			if(conexion.isClosed()) {
				System.out.println("Fallo en Conexión con la Base de Datos");
			}else {
				System.out.println("conexion abierta");			}


		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");
			e.printStackTrace();
		}
	}
	
public  ObservableList<donante> MostrarTablaDonante()throws SQLException{

		
		ObservableList<donante> listadonantes = FXCollections.observableArrayList();
		
		Statement stm=conexion.createStatement();
		String selectsql = "SELECT N_DONANTE,IDENTIFICACION,NOMBRE,APELLIDO1,APELLIDO2,EMAIL,ESTADO,TELEFONO,COD_POSTAL,SEXO,GRUPO_SANGUINEO,CICLO FROM "+user+ ".DONANTE";
		
		try {
			ResultSet resultado = stm.executeQuery(selectsql);
			
			while (resultado.next()) {
				int N_DONANTE=resultado.getInt(1);
				String IDENTIFICACION=resultado.getString(2);
				String NOMBRE=resultado.getString(3);
				String APELLIDO1=resultado.getString(4);
				String APELLIDO2=resultado.getString(5);
				String EMAIL=resultado.getString(6);
				String ESTADO=resultado.getString(7);
				int TELEFONO=resultado.getInt(8);
				int COD_POSTAL=resultado.getInt(9);
				String SEXO=resultado.getString(10);
				String GRUPO_SANGUINEO=resultado.getString(11);
				String CICLO=resultado.getString(12);
				
				
				
				donante persona =new donante(N_DONANTE,IDENTIFICACION,NOMBRE, APELLIDO1, APELLIDO2,
		EMAIL, ESTADO,  TELEFONO, COD_POSTAL, SEXO,  GRUPO_SANGUINEO,CICLO);
				listadonantes.add(persona);
				
			}
		} catch (SQLException sqle) {
			
			int pos= sqle.getMessage().indexOf(":");
			String codeErrorSQL=sqle.getMessage().substring(0,pos);
			System.out.println(codeErrorSQL);
		}
		return listadonantes;
	}

public void GuardarDonantes( int N_donante, String Identificacion, String Nombre, String Apellido1, String Apellido2,
		String Email, String Estado, int Telefono, int Cod_postal, String Sexo, String Grupo_sanguineo,
		String Ciclo) throws SQLException{
	Statement stm = conexion.createStatement();
	
	
	String insertsql = "INSERT INTO "+user+".DONANTE (N_DONANTE,IDENTIFICACION,NOMBRE,APELLIDO1,APELLIDO2,EMAIL,ESTADO,TELEFONO,COD_POSTAL,SEXO,GRUPO_SANGUINEO,CICLO ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt = conexion.prepareStatement(insertsql);
	pstmt.setInt(1, N_donante);
	pstmt.setString(2, Identificacion);
	pstmt.setString(3, Nombre);
	pstmt.setString(4, Apellido1);
	pstmt.setString(5, Apellido2);
	pstmt.setString(6, Email);
	pstmt.setString(7, Estado);
	pstmt.setInt(8, Telefono);
	pstmt.setInt(9,Cod_postal);
	pstmt.setString(10, Sexo);
	pstmt.setString(11, Grupo_sanguineo);
	pstmt.setString(12, Ciclo);
	
	try {
		int resultado = pstmt.executeUpdate();

		if(resultado != 1) {
			System.out.println("Error en la inserción " + resultado);
		}

	
	} catch (SQLException sqle ) {
		
	
		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);

		if(codeErrorSQL.equals("ORA-00955") )
			System.out.println("LA TABLA ESTA CREADA ");
		else
			System.out.println("Ha habido algún problema con  Oracle al hacer la insercion de datos");
	}
	
	
}
public void ActualizarDatos(donante donante1,donante donante2) throws SQLException {
		Statement stm = conexion.createStatement();
		
		
		
		
String updatesql = "UPDATE "+user+".DONANTE SET N_DONANTE= ?, IDENTIFICACION =?, NOMBRE =?, APELLIDO1 =?, APELLIDO2 =?, EMAIL =?, ESTADO =?, TELEFONO =?, COD_POSTAL =?, SEXO =?, GRUPO_SANGUINEO =?, CICLO =? WHERE N_DONANTE=?";
		PreparedStatement pstmt = conexion.prepareStatement(updatesql);
		pstmt.setString(1, Integer.toString(donante2.getN_DONANTE()));
		pstmt.setString(2, donante2.getIDENTIFICACION());
		pstmt.setString(3, donante2.getNOMBRE());
		pstmt.setString(4, donante2.getAPELLIDO1());
		pstmt.setString(5, donante2.getAPELLIDO2());
		pstmt.setString(6, donante2.getEMAIL());
		pstmt.setString(7, donante2.getESTADO());
		pstmt.setString(8, Integer.toString(donante2.getTELEFONO()));
		pstmt.setString(9, Integer.toString(donante2.getCOD_POSTAL()));
		pstmt.setString(10, donante2.getSEXO());
		pstmt.setString(11, donante2.getGRUPO_SANGUINEO());
		pstmt.setString(12, donante2.getCICLO());
		pstmt.setString(13,Integer.toString(donante1.getN_DONANTE()));	
		try {
			int resultado = pstmt.executeUpdate();

			if(resultado != 1) 
				System.out.println("Error en actualizar  " + resultado);
			
	}catch (SQLException sqle ) {
		System.out.println(sqle);
		
		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);

		if(codeErrorSQL.equals("ORA-00955") )
			System.out.println("LA TABLA ESTA CREADA ");
		else
			System.out.println("Ha habido algún problema con  Oracle al hacer la modificacion");
	}
	
	}
public void Borrardonante( int index ) throws SQLException{
	Statement stm = conexion.createStatement();

	
	

	String deletesql = "DELETE FROM "+user+".DONANTE WHERE N_DONANTE = ?" ;
	PreparedStatement pstmt = conexion.prepareStatement(deletesql);
	pstmt.setInt(1, index);
	
	try {
		int resultado = pstmt.executeUpdate();

		if(resultado != 1) {
			System.out.println("Error en eliminar  " + resultado);
		}
}catch (SQLException sqle ) {
	// TODO: handle exception
	
	int pos = sqle.getMessage().indexOf(":");
	String codeErrorSQL = sqle.getMessage().substring(0,pos);

	if(codeErrorSQL.equals("ORA-00955") )
		System.out.println("LA TABLA ESTA CREADA ");
	else
		System.out.println("Ha habido algún problema con  Oracle al hacer el borrado de datos");
}
}

public  ObservableList<donaciones> MostrarTablaDonacion()throws SQLException{

	
	ObservableList<donaciones> listadonaciones = FXCollections.observableArrayList();
	
	Statement stm=conexion.createStatement();
	String selectsql = "SELECT NUM_DONACION,FECHA,TIPO_DONACION,PULSO,TA_SIST,TA_DIAS,HB_CAP,HB_VEN FROM "+user+ ".DONACION";
	
	try {
		ResultSet resultado = stm.executeQuery(selectsql);
		
		while (resultado.next()) {
			int NUM_DONACION=resultado.getInt(1);
			String FECHA=resultado.getString(2);
			String TIPO_DONACION=resultado.getString(3);
			String PULSO=resultado.getString(4);
			String TA_SIST=resultado.getString(5);
			String TA_DIAS=resultado.getString(6);
			String HB_CAP=resultado.getString(7);
			String HB_VEN=resultado.getString(8);
			
			
			
			
			donaciones persona =new donaciones(NUM_DONACION,FECHA,TIPO_DONACION,PULSO,TA_SIST,TA_DIAS,HB_CAP,HB_VEN);
			listadonaciones.add(persona);
			
		}
	} catch (SQLException sqle) {
		
		int pos= sqle.getMessage().indexOf(":");
		String codeErrorSQL=sqle.getMessage().substring(0,pos);
		System.out.println(codeErrorSQL);
	}
	return listadonaciones;
}


public void GuardarDonaciones(int nUM_DONACION, String fECHA, String tIPO_DONACION, String pULSO, String tA_SIST, String tA_DIAS,
		String hB_CAP, String hB_VEN) throws SQLException {
	
Statement stm = conexion.createStatement();
	
	
	String insertsql = "INSERT INTO "+user+".DONACION VALUES (?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt = conexion.prepareStatement(insertsql);
	pstmt.setInt(1, nUM_DONACION);
	pstmt.setString(2, fECHA);
	pstmt.setString(3, tIPO_DONACION);
	pstmt.setString(4, pULSO);
	pstmt.setString(5, tA_SIST);
	pstmt.setString(6, tA_DIAS);
	pstmt.setString(7, hB_CAP);
	pstmt.setString(8, hB_VEN);
	
	
	try {
		int resultado = pstmt.executeUpdate();

		if(resultado != 1) {
			System.out.println("Error en la inserción " + resultado);
		}

	
	} catch (SQLException sqle ) {
		
	
		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);

		if(codeErrorSQL.equals("ORA-00955") )
			System.out.println("LA TABLA ESTA CREADA ");
		else
			System.out.println("Ha habido algún problema con  Oracle al hacer la insercion de datos");
	}
	
	
}
public void ActualizarDatosDonaciones(donaciones donacion1,donaciones donacion2) throws SQLException {
	Statement stm = conexion.createStatement();
	
	
	
	
String updatesql = "UPDATE "+user+".DONACION SET NUM_DONACION= ?, FECHA =?, TIPO_DONACION =?, PULSO =?, TA_SIST =?, TA_DIAS =?, HB_CAP =?, HB_VEN =? WHERE NUM_DONACION=?";
	PreparedStatement pstmt = conexion.prepareStatement(updatesql);
	pstmt.setString(1, Integer.toString(donacion2.getNUM_DONACION()));
	pstmt.setString(2, donacion2.getFECHA());
	pstmt.setString(3, donacion2.getTIPO_DONACION());
	pstmt.setString(4, donacion2.getPULSO());
	pstmt.setString(5, donacion2.getTA_SIST());
	pstmt.setString(6, donacion2.getTA_DIAS());
	pstmt.setString(7, donacion2.getHB_CAP());
	pstmt.setString(8, donacion2.getHB_VEN());
	
	pstmt.setString(9,Integer.toString(donacion1.getNUM_DONACION()));	
	try {
		int resultado = pstmt.executeUpdate();

		if(resultado != 1) 
			System.out.println("Error en actualizar  " + resultado);
		
}catch (SQLException sqle ) {
	System.out.println(sqle);
	
	int pos = sqle.getMessage().indexOf(":");
	String codeErrorSQL = sqle.getMessage().substring(0,pos);

	if(codeErrorSQL.equals("ORA-00955") )
		System.out.println("LA TABLA ESTA CREADA ");
	else
		System.out.println("Ha habido algún problema con  Oracle al hacer la modificacion");
}

}

public void GuardarFormulario(Integer codigo_form, String pregunta1, String pregunta2, String pregunta3, String pregunta4,
		String pregunta5, String pregunta6, String pregunta7, String pregunta8, String pregunta9, String pregunta10,
		String pregunta11, String pregunta12, String pregunta13, String pregunta14, String pregunta15,
		String pregunta16, String pregunta17, String pregunta18, String pregunta19, String pregunta20,
		String pregunta21, String pregunta22, String pregunta23, String pregunta24, String pregunta25,
		String pregunta26, String pregunta27, String pregunta28, String pregunta29, String pregunta30,
		String pregunta31, String pregunta32, String preguntaex1, String preguntaex2, String preguntaex3,
		String fecha_form) throws SQLException {

	
	
	String insertsql = "INSERT INTO "+user+".FORMULARIO  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt = conexion.prepareStatement(insertsql);
	
	pstmt.setInt(1,codigo_form);
	pstmt.setString(2,pregunta1 );
	pstmt.setString(3,pregunta2 );
	pstmt.setString(4,pregunta3 );
	pstmt.setString(5,pregunta4 );
	pstmt.setString(6,pregunta5 );
	pstmt.setString(7,pregunta6);
	pstmt.setString(8,pregunta7 );
	pstmt.setString(9,pregunta8);
	pstmt.setString(10,pregunta9);
	pstmt.setString(11,pregunta10 );
	pstmt.setString(12, pregunta11);
	pstmt.setString(13,pregunta12 );
	pstmt.setString(14,pregunta13 );
	pstmt.setString(15,pregunta14 );
	pstmt.setString(16, pregunta15);
	pstmt.setString(17,pregunta16 );
	pstmt.setString(18,pregunta17 );
	pstmt.setString(19,pregunta18 );
	pstmt.setString(20,pregunta19 );
	pstmt.setString(21,pregunta20 );
	pstmt.setString(22,pregunta21 );
	pstmt.setString(23,pregunta22 );
	pstmt.setString(24,pregunta23);
	pstmt.setString(25,pregunta24);
	pstmt.setString(26,pregunta25 );
	pstmt.setString(27,pregunta26);
	pstmt.setString(28,pregunta27 );
	pstmt.setString(29,pregunta28 );
	pstmt.setString(30,pregunta29 );
	pstmt.setString(31,pregunta30 );
	pstmt.setString(32,pregunta31);
	pstmt.setString(33,pregunta32);
	pstmt.setString(34,preguntaex1 );
	pstmt.setString(35,preguntaex2);
	pstmt.setString(36,preguntaex3 );
	pstmt.setString(37,fecha_form);

	
	try {
		int resultado = pstmt.executeUpdate();

		if(resultado != 1) {
			System.out.println("Error en la inserción " + resultado);
		}

	
	} catch (SQLException sqle ) {
		
	
		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);

		if(codeErrorSQL.equals("ORA-00955") )
			System.out.println("LA TABLA ESTA CREADA ");
		else
			System.out.println("Ha habido algún problema con  Oracle al hacer la insercion de datos");
	}
	
	
}
}





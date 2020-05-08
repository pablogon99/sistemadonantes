package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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


}
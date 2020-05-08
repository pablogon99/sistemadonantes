package modelo;

import java.io.File;

public class donante {

	private int N_DONANTE;
	private String IDENTIFICACION;
	private String NOMBRE;
	private String APELLIDO1;
	private String APELLIDO2;
	private String EMAIL;
	private String ESTADO;
	private int  TELEFONO;
	private int COD_POSTAL;
	private File FOTO;
	private String SEXO;
	private String GRUPO_SANGUINEO;
	private String CICLO;
	
	
	
	
	public donante(int n_DONANTE, String iDENTIFICACION, String nOMBRE, String aPELLIDO1, String aPELLIDO2,
			String eMAIL, String eSTADO, int tELEFONO, int cOD_POSTAL, String sEXO, String gRUPO_SANGUINEO,
			String cICLO) {
		super();
		N_DONANTE = n_DONANTE;
		IDENTIFICACION = iDENTIFICACION;
		NOMBRE = nOMBRE;
		APELLIDO1 = aPELLIDO1;
		APELLIDO2 = aPELLIDO2;
		EMAIL = eMAIL;
		ESTADO = eSTADO;
		TELEFONO = tELEFONO;
		COD_POSTAL = cOD_POSTAL;
		SEXO = sEXO;
		GRUPO_SANGUINEO = gRUPO_SANGUINEO;
		CICLO = cICLO;
	}
	
	public File getFOTO() {
		return FOTO;
	}

	public void setFOTO(File fOTO) {
		FOTO = fOTO;
	}

	public donante(int n_DONANTE, String iDENTIFICACION, String nOMBRE, String aPELLIDO1, String aPELLIDO2,
			String eMAIL, String eSTADO, int tELEFONO, int cOD_POSTAL, File fOTO, String sEXO, String gRUPO_SANGUINEO,
			String cICLO) {
		super();
		N_DONANTE = n_DONANTE;
		IDENTIFICACION = iDENTIFICACION;
		NOMBRE = nOMBRE;
		APELLIDO1 = aPELLIDO1;
		APELLIDO2 = aPELLIDO2;
		EMAIL = eMAIL;
		ESTADO = eSTADO;
		TELEFONO = tELEFONO;
		COD_POSTAL = cOD_POSTAL;
		FOTO = fOTO;
		SEXO = sEXO;
		GRUPO_SANGUINEO = gRUPO_SANGUINEO;
		CICLO = cICLO;
	}

	public int getN_DONANTE() {
		return N_DONANTE;
	}
	public void setN_DONANTE(int n_DONANTE) {
		N_DONANTE = n_DONANTE;
	}
	public String getIDENTIFICACION() {
		return IDENTIFICACION;
	}
	public void setIDENTIFICACION(String iDENTIFICACION) {
		IDENTIFICACION = iDENTIFICACION;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public String getAPELLIDO1() {
		return APELLIDO1;
	}
	public void setAPELLIDO1(String aPELLIDO1) {
		APELLIDO1 = aPELLIDO1;
	}
	public String getAPELLIDO2() {
		return APELLIDO2;
	}
	public void setAPELLIDO2(String aPELLIDO2) {
		APELLIDO2 = aPELLIDO2;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getESTADO() {
		return ESTADO;
	}
	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}
	public int getTELEFONO() {
		return TELEFONO;
	}
	public void setTELEFONO(int tELEFONO) {
		TELEFONO = tELEFONO;
	}
	public int getCOD_POSTAL() {
		return COD_POSTAL;
	}
	public void setCOD_POSTAL(int cOD_POSTAL) {
		COD_POSTAL = cOD_POSTAL;
	}
	
	public String getSEXO() {
		return SEXO;
	}
	public void setSEXO(String sEXO) {
		SEXO = sEXO;
	}
	public String getGRUPO_SANGUINEO() {
		return GRUPO_SANGUINEO;
	}
	public void setGRUPO_SANGUINEO(String gRUPO_SANGUINEO) {
		GRUPO_SANGUINEO = gRUPO_SANGUINEO;
	}
	public String getCICLO() {
		return CICLO;
	}
	public void setCICLO(String cICLO) {
		CICLO = cICLO;
	}
	
	
	
}


package modelo;

public class donaciones {
 private int NUM_DONACION;
 private String FECHA;
 private String TIPO_DONACION;
 private String PULSO;
 private String TA_SIST;
 private String TA_DIAS;
 private String HB_CAP;
 private String HB_VEN;
 


public donaciones(int nUM_DONACION, String fECHA, String tIPO_DONACION, String pULSO, String tA_SIST, String tA_DIAS,
		String hB_CAP, String hB_VEN) {
	super();
	NUM_DONACION = nUM_DONACION;
	FECHA = fECHA;
	TIPO_DONACION = tIPO_DONACION;
	PULSO = pULSO;
	TA_SIST = tA_SIST;
	TA_DIAS = tA_DIAS;
	HB_CAP = hB_CAP;
	HB_VEN = hB_VEN;
}

public int getNUM_DONACION() {
	return NUM_DONACION;
}

public void setNUM_DONACION(int nUM_DONACION) {
	NUM_DONACION = nUM_DONACION;
}

public String getFECHA() {
	return FECHA;
}

public void setFECHA(String fECHA) {
	FECHA = fECHA;
}

public String getTIPO_DONACION() {
	return TIPO_DONACION;
}

public void setTIPO_DONACION(String tIPO_DONACION) {
	TIPO_DONACION = tIPO_DONACION;
}

public String getPULSO() {
	return PULSO;
}

public void setPULSO(String pULSO) {
	PULSO = pULSO;
}

public String getTA_SIST() {
	return TA_SIST;
}

public void setTA_SIST(String tA_SIST) {
	TA_SIST = tA_SIST;
}

public String getTA_DIAS() {
	return TA_DIAS;
}

public void setTA_DIAS(String tA_DIAS) {
	TA_DIAS = tA_DIAS;
}

public String getHB_CAP() {
	return HB_CAP;
}

public void setHB_CAP(String hB_CAP) {
	HB_CAP = hB_CAP;
}

public String getHB_VEN() {
	return HB_VEN;
}

public void setHB_VEN(String hB_VEN) {
	HB_VEN = hB_VEN;
}
 
 
}

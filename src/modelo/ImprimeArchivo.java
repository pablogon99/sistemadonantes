package modelo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



	public class ImprimeArchivo {

		private String filename;
		private String filepath;
		private int N_DONANTE;
		private String NOMBRE;
		private String APELLIDO1;
		private String APELLIDO2;
		private String CICLO;

		public ImprimeArchivo(String filename, String filepath) {
			super();
			this.filename = filename;
			this.filepath = filepath;
		}



		public ImprimeArchivo(String filename, String filepath, int n_DONANTE, String nOMBRE, String aPELLIDO1,
				String aPELLIDO2, String cICLO) {
			super();
			this.filename = filename;
			this.filepath = filepath;
			N_DONANTE = n_DONANTE;
			NOMBRE = nOMBRE;
			APELLIDO1 = aPELLIDO1;
			APELLIDO2 = aPELLIDO2;
			CICLO = cICLO;
		}

		


		public String getFilename() {
			return filename;
		}



		public void setFilename(String filename) {
			this.filename = filename;
		}



		public String getFilepath() {
			return filepath;
		}



		public void setFilepath(String filepath) {
			this.filepath = filepath;
		}



		public int getN_DONANTE() {
			return N_DONANTE;
		}



		public void setN_DONANTE(int n_DONANTE) {
			N_DONANTE = n_DONANTE;
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



		public String getCICLO() {
			return CICLO;
		}



		public void setCICLO(String cICLO) {
			CICLO = cICLO;
		}



		/* Este método generará el PDF  */
		public void generarArchivoPDF(int n_DONANTE, String nOMBRE, String aPELLIDO1,
				String aPELLIDO2, String cICLO) throws FileNotFoundException, DocumentException {

			// Crea el nombre del archivo con el path, el nombre del  fichero y la extensión PDF
			String sFileNamePath = filepath + filename+".pdf";

			// Se crea el documento que se va a imprimir
			Document documento = new Document();


			// En principio el tamaño de la página está paara un A4 en vertical, pero puedes investigar y cambiar el tamaño de la zona de impresión
			// Eso sí... te tocará investigar y buscar: el método setPageSize
			//documento.setPageSize() Lo que le pases como  argumento

			System.out.println(sFileNamePath);

			// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
			FileOutputStream ficheroPdf = new FileOutputStream(sFileNamePath);

			// Se asocia el documento al OutputStream y se indica que el espaciado entre
			// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
			PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

			// Se abre el documento.
			documento.open();

			// La unidad para imprimir es el párrafo se pasa el texto del párrafo, se pueden poner saltos de línea dentro
			// el tipo, tamaño de letra y si es en negrita (BOLD), cursiva (ITALIC), en cursivaNEgrita (BOLDITALIC) o normal (NORMAL)

			Paragraph p1 = new Paragraph("NUMERO DE DONANTE : "+n_DONANTE,
			FontFactory.getFont("arial",   // fuente
			11,                            // tamaño
			Font.BOLD));

			// Una vez creado el párrafo puedes modificar varias opciones... como aquí la alineación
			// ALIGN_CENTER || ALIGN_LEFT || ALIGN_RIGHT ALIGN_JUSTIFY
			p1.setAlignment(Element.ALIGN_CENTER);

			// Añade el párrafo al documeento
			documento.add(p1);


			Paragraph p2 = new Paragraph("NOMBRE: "+nOMBRE,
					FontFactory.getFont("Garamond",   // fuente
					14,                            // tamaño
					Font.ITALIC));

			
			p2.setAlignment(Element.ALIGN_LEFT);

			
			documento.add(p2);

			
			
			
			Paragraph p3 = new Paragraph("APELLIDO1: "+aPELLIDO1,
					FontFactory.getFont("Garamond",   // fuente
					14,                            // tamaño
					Font.ITALIC));

			
			p3.setAlignment(Element.ALIGN_LEFT);

			
			documento.add(p3);
			
			Paragraph p4 = new Paragraph("APELLIDO2: "+aPELLIDO2,
					FontFactory.getFont("Garamond",   // fuente
					14,                            // tamaño
					Font.ITALIC));

			
		
			p4.setAlignment(Element.ALIGN_LEFT);

			
			documento.add(p4);
			
			Paragraph p5 = new Paragraph("CICLO: "+cICLO);
					FontFactory.getFont("Garamond",   // fuente
					14,                            // tamaño
					Font.ITALIC);

			
		
			p5.setAlignment(Element.ALIGN_LEFT);

			
			documento.add(p5);
			try
			{
				String path = "src\\modelo\\chiquito.jpg";
				Image foto = Image.getInstance(path);
				foto.scaleToFit(90, 90);
				foto.setAbsolutePosition(20, 740);
				documento.add(foto);
			}
			catch ( Exception e )
			{
				System.out.println(e.getMessage());
			}




			documento.close();


		}

	}



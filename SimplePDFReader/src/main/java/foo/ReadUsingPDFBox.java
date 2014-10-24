package foo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class ReadUsingPDFBox {

//Extract text from PDF Document
	static String pdftoText() throws IOException {
		
		  URL oracle = new URL("http://ceoaperms.ap.gov.in/Electoral_Rolls/PDFGeneration.aspx?urlPath=D:\\FinalRolls_2014\\AC_212\\English\\AC212_FIN_E_093.PDF");
	        InputStream  in = oracle.openStream();
	        
		
		PDFParser parser;
		String parsedText = null;;
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		try {
			parser = new PDFParser(in);
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			return null;
		}
		try {
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			pdfStripper.setStartPage(3);
			pdfStripper.setEndPage(10);
			
			parsedText = pdfStripper.getText(pdDoc);
		} catch (Exception e) {
			System.err
					.println("An exception occured in parsing the PDF Document."
							+ e.getMessage());
		} finally {
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return parsedText;
	}
	public static void main(String args[]) throws IOException{
		System.out.println(pdftoText());
	}
}

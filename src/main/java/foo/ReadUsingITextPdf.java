package foo;

import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class ReadUsingITextPdf {
	public static void main(String args[]) throws IOException{
		System.out.println(pdftoText());
	}

	private static String pdftoText() throws IOException {
		
		PdfReader reader = new PdfReader("http://ceoaperms.ap.gov.in/Electoral_Rolls/PDFGeneration.aspx?urlPath=D:\\FinalRolls_2014\\AC_212\\English\\AC212_FIN_E_093.PDF");
		
		PdfReaderContentParser parser = new

				PdfReaderContentParser(reader);

		TextExtractionStrategy strategy = null;
		StringBuffer buffer=new StringBuffer();

		for(int i = 1; i <= reader.getNumberOfPages(); i++) {

		       strategy = parser.processContent(i,new SimpleTextExtractionStrategy());
		       buffer.append(strategy.getResultantText());
		       System.out.println(strategy.getResultantText());

		}
		return buffer.toString();
	}

}

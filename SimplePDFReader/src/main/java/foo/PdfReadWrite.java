package foo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class PdfReadWrite 
{
	public static void main(String[] args) throws IOException {

        URL oracle = new URL("http://ceoaperms.ap.gov.in/Electoral_Rolls/PDFGeneration.aspx?urlPath=D:\\FinalRolls_2014\\AC_212\\English\\AC212_FIN_E_093.PDF");
        InputStream  in = oracle.openStream();
        
        OutputStream oos = new FileOutputStream("test.pdf");

        byte[] buf = new byte[8192];

        //InputStream is = new FileInputStream(f);

        int c = 0;

        while ((c = in.read(buf, 0, buf.length)) > 0) {
            oos.write(buf, 0, c);
            oos.flush();
        }

        oos.close();
        System.out.println("stop");
        in.close();

    }
}

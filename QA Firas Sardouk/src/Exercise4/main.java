package Exercise4;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class main {

    public static void main(String args[]) {
    	
        PDF_Manipulation PDF_M=new PDF_Manipulation();
        PDF_M.createPdfFile("test1.pdf");
        //PDF_M.sign_PDF("sample_measurements.pdf");
        /*try 
        {
			PDF_M.verifySignatures("test1.pdf");
			PDF_M.verifySignatures("signed_PDF.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}*/
        
    }
}
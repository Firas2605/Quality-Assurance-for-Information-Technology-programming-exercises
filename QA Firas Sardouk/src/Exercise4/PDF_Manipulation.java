package Exercise4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDF_Manipulation {
	
	public void createPdfFile(String fileName)
	{
		Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
	         document.open();
	         document.add(new Paragraph("A Hello World PDF document."));
	         
	         document.close();
	         writer.close();
	         System.out.println("PDF created ! \n");

	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	}
	
	
	
	public void sign_PDF(String path)
	{
				
		File file = new File(path); 
		PDDocument pdDocument = null;
		try 
		{
				pdDocument = PDDocument.load(file);
		} 
		catch (IOException e)
		{
					// TODO Auto-generated catch block
					e.printStackTrace();
		}

		try 
		{ 
			PDSignature pdSignature = new PDSignature();
			pdSignature.setFilter(PDSignature.FILTER_VERISIGN_PPKVS);
			pdSignature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_SHA1);
			pdSignature.setName("Firas Sardouk");
			pdSignature.setLocation("Miskolc, Hungary");
			pdSignature.setReason("Sample Signature test");
			pdSignature.setSignDate(Calendar.getInstance());
			pdDocument.addSignature(pdSignature);		 
			pdDocument.save("signed_PDF.pdf");
			pdDocument.close();
			System.out.println("PDF signed !\n");
	 
		}
		catch (IOException ioe)
		{
					System.out.println("Error while saving pdf" + ioe.getMessage());
		}
	}
	
	
	
	public static void verifySignatures(String path) throws IOException, GeneralSecurityException 
	{
		System.out.println(path);
        PdfReader reader = new PdfReader(path);
        AcroFields fields = reader.getAcroFields();
        ArrayList<String> names = fields.getSignatureNames();
        if(names.size()== 0) 
        	System.out.println("Document is not signed");
        else
        	System.out.println("Document is signed");

	}
}

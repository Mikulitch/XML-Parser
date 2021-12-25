package by.epam.training.mikulich.xmlparser.validator;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidator {
  
    public boolean isFileValid(File fileName, File schemaName) {
    	 System.out.println("1");
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        File schemaFile = new File("D:\\свеаю\\Epam Training\\XML\\src\\main\\resources\\tariffs.xsd"); 
        System.out.println("2");
        SchemaFactory factory = SchemaFactory.newInstance(language);
        System.out.println("3");
        if (fileName == null || schemaName == null) {return false;}
     
        try {
        
            Schema schema = factory.newSchema(schemaFile);
            System.out.println("4");
            Validator validator = schema.newValidator();
            System.out.println("5");
            Source source = new StreamSource(fileName);
            System.out.println("6");
            //validator.setErrorHandler(new TariffErrorHandler());
            System.out.println("7");
            validator.validate(source);
            System.out.println("21");
            return true;
        } catch (SAXException | IOException e) {
        	  System.out.println("22"+e);
        }
        return false;
    }
}
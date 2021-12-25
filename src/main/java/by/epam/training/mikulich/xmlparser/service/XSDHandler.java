package by.epam.training.mikulich.xmlparser.service;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class XSDHandler {
    private Properties PROPERTIES;

    private String propertiesFile = "application.properties";
    private String propertiesName = "Gems_scheme.xsd";
    private File XSDFile;

    public File getXSDFile() {
        return XSDFile;
    }

    {
    
        PROPERTIES = new Properties();
     
        
        try {
            PROPERTIES.load(new FileInputStream("D:\\свеаю\\Epam Training\\XML\\src\\main\\resources\\application.properties"));
           
            

            XSDFile = new File(PROPERTIES.getProperty(propertiesName));
           
        } catch (IOException e) {
        	  System.out.println("warning xsdHandler");
        }
    }

    public String getPropertiesName() {
        return propertiesName;
    }

    public void setPropertiesName(String propertiesName) {
        this.propertiesName = propertiesName;
    }

    public String getPropertiesFile() {
        return propertiesFile;
    }

    public void setPropertiesFile(String propertiesFile) {
        this.propertiesFile = propertiesFile;
    }

}

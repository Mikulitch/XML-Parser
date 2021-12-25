package by.epam.training.mikulich.xmlparser.parsers;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import by.epam.training.mikulich.xmlparser.entity.Gem;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

public class SaxBuilder {
 
    private Set<Gem> gems;
    private SaxHandler handler = new SaxHandler();
    private XMLReader reader;

    public SaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
           
        }
       
        reader.setContentHandler(handler);
    }

    public void buildSetGems(String filename) {
       try {
           reader.parse(new InputSource(new FileInputStream(filename)));
        } catch (IOException | SAXException e) {
            
        }
        gems = handler.getGems();
    }

    public Set<Gem> getGems() {
        return gems;
    }
}

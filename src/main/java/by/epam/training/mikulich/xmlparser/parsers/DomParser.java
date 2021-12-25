package by.epam.training.mikulich.xmlparser.parsers;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.training.mikulich.xmlparser.entity.Gem;
import by.epam.training.mikulich.xmlparser.entity.Preciousness;
import by.epam.training.mikulich.xmlparser.entity.XmlTag;
import by.epam.training.mikulich.xmlparser.exception.ParserException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class DomParser {
    private static final long serialVersionUID = 127L;
 
    private Set<Gem> gems;
    private DocumentBuilder docBuilder;

    public DomParser() {
        gems = new TreeSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
           
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
        	e.printStackTrace();
        }
    }

    public void buildSetTariffs(String filename) throws ParserException {
        Document doc;
        
        if (filename == null) {
       
            throw new ParserException("filename is null");
        }
        try {
        	
            doc = docBuilder.parse(new File(filename));
            Element root = doc.getDocumentElement();
            NodeList gemList = root.getElementsByTagName("gem");
           
            for (int i = 0; i < gemList.getLength(); i++) {
            	
                Element gemElement = (Element) gemList.item(i);
                Gem gem = gemBuilder(gemElement);
                gems.add(gem);
            }
        } catch (IOException | SAXException e) {
        	e.printStackTrace();
        }
    }

    private Gem gemBuilder(Element gemElement) {
       Gem gem = new Gem();
        //gem.setCallPrices(new CallPrices());
       // gem.setParameters(new Parameters());

        gem.setId(Integer.valueOf(getElementTextContent(gemElement, XmlTag.ID.getValue())));
        gem.setName(getElementTextContent(gemElement, XmlTag.NAME.getValue()));
        gem.setPreciousness(Preciousness.valueOf(getElementTextContent(gemElement, XmlTag.PRECIOUSNESS.getValue())));
        gem.setOrigin(getElementTextContent(gemElement, XmlTag.ORIGIN.getValue()));
        gem.setValue(Double.valueOf(getElementTextContent(gemElement, XmlTag.VALUE.getValue())));
        
        Element visualParElement = (Element) gemElement.getElementsByTagName( XmlTag.VISUALPARAMETRS.getValue()).item(0);
        gem.getVisualPar().setColor(getElementTextContent(visualParElement, XmlTag.COLOR.getValue()));
        gem.getVisualPar().setTransparency(Integer.valueOf(getElementTextContent(visualParElement, XmlTag.TRANSPARENCY.getValue())));
        gem.getVisualPar().setFacets(Integer.valueOf(getElementTextContent(visualParElement, XmlTag.FACETS.getValue())));

        return gem;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

    public Set<Gem> getGems() {
        return gems;
    }
}

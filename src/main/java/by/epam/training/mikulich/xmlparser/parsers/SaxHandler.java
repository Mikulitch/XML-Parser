package by.epam.training.mikulich.xmlparser.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.training.mikulich.xmlparser.entity.Gem;
import by.epam.training.mikulich.xmlparser.entity.Preciousness;
import by.epam.training.mikulich.xmlparser.entity.VisualPar;
import by.epam.training.mikulich.xmlparser.entity.XmlTag;


import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;

public class SaxHandler extends DefaultHandler {

	private Set<Gem> gems;
	private Gem current;
	private XmlTag currentXmlTag;
	private EnumSet<XmlTag> withText;
	private String element = "gem";

	public SaxHandler() {
		gems = new TreeSet<>();
		// withText = EnumSet.range(XmlTag.TARIFF, XmlTag.OPENDATE);
	}

	public void startElement(String uri, String localName, String qName, Attributes attrs) {
		if (element.equals(qName)) {
			current = new Gem();
			current.setVisualPar(new VisualPar());

		} else {
			try {
				XmlTag temp = XmlTag.valueOf(qName.toUpperCase());
				if (withText.contains(temp)) {
					currentXmlTag = temp;
				}
			} catch (IllegalArgumentException e) {
				// LOGGER.error(e);
			}
		}
	}

	public void endElement(String uri, String localName, String qName) {
		if (element.equals(qName)) {
			gems.add(current);
		}
	}

	public void characters(char[] ch, int start, int length) {
		String data = new String(ch, start, length).trim();
		if (currentXmlTag != null) {
			
			  
			  switch (currentXmlTag) { 
			  	
			  	case NAME: current.setName(data); break;
			  	
			  	case PRECIOUSNESS: current.setPreciousness(Preciousness.valueOf(data)); break;
			  
			  	case ID : current.setId(Integer.valueOf(data)); break; 
			  	case ORIGIN : current.setOrigin(data); break; 
			  	case COLOR :current.getVisualPar().setColor(data); break; 
			  	case TRANSPARENCY : current.getVisualPar().setTransparency(Integer.valueOf(data)); break; 
			  	case FACETS : current.getVisualPar().setFacets(Integer.valueOf(data)); break; 
			  	case  VALUE: current.setValue(Double.valueOf(data)); break; 
			  
			  
			  default:
			  throw new EnumConstantNotPresentException( currentXmlTag.getDeclaringClass(),
			  currentXmlTag.name()); }
			 
		}
		currentXmlTag = null;
	}

	public Set<Gem> getGems() {
		return gems;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

}
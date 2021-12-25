package by.epam.training.mikulich.xmlparser.service;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.training.mikulich.xmlparser.entity.Gem;
import by.epam.training.mikulich.xmlparser.exception.ParserException;
import by.epam.training.mikulich.xmlparser.parsers.DomParser;
import by.epam.training.mikulich.xmlparser.parsers.SaxBuilder;
import by.epam.training.mikulich.xmlparser.parsers.StaxBuilder;
import by.epam.training.mikulich.xmlparser.tablebuild.GemSet;

import java.io.IOException;
import java.util.Set;

public class ParsersHandler extends HttpServlet {
    private static final long serialVersionUID = 192L;
  
    private static String filePath;

    public ParsersHandler() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("parsers.jsp");
        requestDispatcher.forward(request, response);
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    	 
        response.setContentType("text/html");
     	 
        Set<Gem> set = null;
     	 
        String parser = request.getParameter("parser");
     	

        switch (parser) {
            case "DOM": {
             	  DomParser domParser = new DomParser();
               try {
            	   domParser.buildSetTariffs(filePath);  
                } catch (ParserException e) {
                	e.printStackTrace();
                }
                 set = domParser.getGems();
                      break;
            }
            case "SAX": {
                SaxBuilder saxBuilder = new SaxBuilder();
                saxBuilder.buildSetGems(filePath);
                set = saxBuilder.getGems();
                break;
            }
            case "StAX": {
               StaxBuilder staxBuilder = new StaxBuilder();
               
                }
            

            default:
            	  System.out.println("incorrect parse type");
            	  
        }
     
        GemSet gembean = new GemSet(set);
        
        request.setAttribute("gembean", gembean);
        
        try {
        	
            request.getRequestDispatcher("table.jsp").forward(request, response);
          
        } catch (ServletException | IOException e) {
        	e.printStackTrace();
        }
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        ParsersHandler.filePath = filePath;
    }
}

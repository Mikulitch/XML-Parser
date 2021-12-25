package by.epam.training.mikulich.xmlparser.service;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import by.epam.training.mikulich.xmlparser.validator.XSDValidator;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class FileUploadController extends HttpServlet {


    private static final long serialVersionUID = 161L;

    private static final String NO_FILE_UPLOADED_MESSAGE = "No File Uploaded";
    private static final String INVALID_XML_FILE_MESSAGE = "Invalid XML-file";
    private static final String VALID_XML_FILE_MESSAGE = "Congratulations! XML-file is valid!";
    private static final String MAIN_PAGE_LINK_NAME = "BACK TO MAIN PAGE";
    private static final String PARSER_PAGE_LINK_NAME = "Choose parser";
    private static final String PARSER_PAGE_LINK = "parsers.jsp";
    private static final String MAIN_PAGE_LINK = "index.jsp";

    private File file;
    private int maxFileSize = 200 * 1024;
    private int maxMemSize = 200 * 1024;
    private String filePath;

    public FileUploadController() {
    }

    public void init() {
    	 filePath =  getServletContext().getInitParameter("file-upload");
    	
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
   
        File xsdFile = new XSDHandler().getXSDFile();
   
        try {
      
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            
            if (!isMultipart) {
                printHTMLpage(request, response, NO_FILE_UPLOADED_MESSAGE, MAIN_PAGE_LINK, MAIN_PAGE_LINK_NAME);
               
                return;
            }
          
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String fileName;
          
            DiskFileItemFactory factory = new DiskFileItemFactory();
          
            factory.setSizeThreshold(maxMemSize);
        
            factory.setRepository(new File(""));
            
            ServletFileUpload upload = new ServletFileUpload(factory);
     
            upload.setSizeMax(maxFileSize);
            System.out.println("ddd");
         
            try {
                List<FileItem> fileItems = upload.parseRequest(new ServletRequestContext(request));
                
                Iterator<FileItem> iteratorFileItems = fileItems.iterator();
                
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet upload</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div align = center>");
                
                    while (iteratorFileItems.hasNext()) {
                    FileItem fi =  (FileItem)iteratorFileItems.next();
              
                    if (!fi.isFormField()) {
                    	
                        fileName = fi.getName();
                        if( fileName.lastIndexOf("\\") >= 0 )
                                {
                                   file = new File( filePath + 
                                   fileName.substring(fileName.lastIndexOf("\\"))) ;
                                }
                                else
                                {
                                   file = new File( filePath + 
                                   fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                                }
                       
                       
                        fi.write(file);
                        int index = fileName.lastIndexOf("\\");
                        if (index > 0) {
                        	fileName = fileName.substring(index);
                        }
                        out.println("Uploaded File: " + fileName + "<br>");
                       
                    }
                }

                XSDValidator xmlValidator = new XSDValidator();
                boolean isXMLFileValid = xmlValidator.isFileValid(file, xsdFile);
                if (!isXMLFileValid) {
                    printHTMLpage(request, response, INVALID_XML_FILE_MESSAGE, MAIN_PAGE_LINK, MAIN_PAGE_LINK_NAME);
                    return;
                }
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                ParsersHandler.setFilePath(file.getPath());
                printHTMLpage(request, response, VALID_XML_FILE_MESSAGE, PARSER_PAGE_LINK, PARSER_PAGE_LINK_NAME);

            } catch (FileNotFoundException e) {
               
                printHTMLpage(request, response, NO_FILE_UPLOADED_MESSAGE, MAIN_PAGE_LINK, MAIN_PAGE_LINK_NAME);
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(MAIN_PAGE_LINK);
        requestDispatcher.forward(req, response);
    }

    public void printHTMLpage(HttpServletRequest request, HttpServletResponse response, String message,
                              String link, String linkName) {
        response.setContentType("text/html");
        try {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div align = center>");
            out.println(message);
            out.println("<br><br>");
            out.println("<a href = " + link + ">" + linkName + "</a></div>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}

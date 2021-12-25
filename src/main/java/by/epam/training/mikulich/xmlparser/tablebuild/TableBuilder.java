package by.epam.training.mikulich.xmlparser.tablebuild;



import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;

import by.epam.training.mikulich.xmlparser.entity.Gem;


import java.io.IOException;
import java.util.ArrayList;

public class TableBuilder extends TagSupport {
    private static final long serialVersionUID = 11234L;
    private GemSet set;

    public GemSet getSet() {
        return set;
    }
    public void setSet(GemSet set) {
        this.set = set;
    }

    @Override
    public int doStartTag() {
    	System.out.println("ssss");
        ArrayList<Gem> gems = new ArrayList<>();
        StringBuilder row;
        ArrayList<String> strings = new ArrayList<>();
       try {
            JspWriter out = pageContext.getOut();
            out.write("<html>");
            out.write("<head>");
            out.write("<title>Servlet upload</title>");
            out.write("</head>");
            out.write("<body>");
            out.write("<div align = center>");
            out.write("Tariffs");
            out.write("</div>");
            out.write("<table border=2 name=Tariffs>");
            out.write("<tr><th>ID</th><th>Name</th>" +
                    "<th>Preciousness</th><th>Origin</th><th>Color</th><th>Transparency</th>" +
                    "<th>Facets</th><th>Value</th>");
           for (Object objGem : set.getSet()) {
               gems.add((Gem) objGem);
           }
           for (Gem gem : gems) {
               row = new StringBuilder();
               row.append("<tr>");
               row.append("<td>");
               row.append(gem.getId());
               row.append("</td><td>");
               row.append(gem.getName().toString());
               row.append("</td><td>");
               row.append(gem.getPreciousness().toString());
               row.append("</td><td>");
               row.append(gem.getOrigin().toString());
               row.append("</td><td>");
               row.append(gem.getVisualPar().getColor().toString());
               row.append("</td><td>");
               row.append(gem.getVisualPar().getTransparency().toString());
               row.append("</td><td>");
               row.append(gem.getVisualPar().getFacets().toString());
               row.append("</td>");
               row.append("</tr>");
               strings.add(row.toString());
           }
               for (String string : strings) {
                   out.write(string);
               }
               out.write("</table>");
               out.write("<br><br>");
               out.write("<a href = parsers.jsp>BACK TO PARSERS</a></div>");
               out.write("<br><br>");
               out.write("<a href = index.jsp>BACK TO MAIN PAGE</a></div>");
               out.write("</body>");
               out.write("</html>");
               out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}

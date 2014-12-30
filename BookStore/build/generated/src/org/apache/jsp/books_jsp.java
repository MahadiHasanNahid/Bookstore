package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mahadihasan.bookstore.*;
import com.mahadihasan.bookstore.servlet.*;
import java.util.*;

public final class books_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Book List</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\"\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <p class=\"bigFont\">Available Books</p>\n");
      out.write("        <p class=\"bold\">Click a link to view book information</p>\n");
      out.write("        \n");
      out.write("        <p>\n");
      out.write("            \n");
      out.write("            ");

            TitlesBean titlesBean = new TitlesBean();
            List titles = titlesBean.getTitles();
            BookBean currenBook;
            
            session.setAttribute("titles", titles);
            Iterator iterator = titles.iterator();
            
            while (iterator.hasNext()) {
                currenBook = (BookBean) iterator.next();
            
            
            
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <span class=\"bold\">\n");
      out.write("                \n");
      out.write("                <a href=\"displayBook?isbn");
      out.print( currenBook.getISBN());
      out.write("\">\n");
      out.write("                    ");
      out.print( currenBook.getTitle() + ", "+ 
                            currenBook.getEditionNumber()+"e" );
      out.write("\n");
      out.write("                </a>\n");
      out.write("            </span><br/>\n");
      out.write("            \n");
      out.write("            ");

            }
            
      out.write("\n");
      out.write("        </p>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

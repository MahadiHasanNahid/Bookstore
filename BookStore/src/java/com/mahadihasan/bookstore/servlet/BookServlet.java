package com.mahadihasan.bookstore.servlet;

import com.mahadihasan.bookstore.BookBean;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author MdMahadiHasan
 */
public class BookServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/index.html");
        
        if(session == null) {
            dispatcher.forward(request, response);
        }
        
        List titles = (List) session.getAttribute("titles");
        Iterator iterator = titles.iterator();
        BookBean book = null;
        
        String isbn = request.getParameter("isbn");
        
        while (iterator.hasNext()) {
            book = (BookBean) iterator.next();
            
            if(isbn.equals(book.getISBN())) {
                session.setAttribute("bookToAdd", isbn);
                break;
            }
        }
        
        
        if(book == null) {
            dispatcher.forward(request, response);
        }
        
        try {
            DocumentBuilderFactory factory = 
                    DocumentBuilderFactory.newInstance();
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document messageDocument = builder.newDocument();
            
            Element bookElement = book.getXML(messageDocument);
            messageDocument.appendChild(bookElement);
            
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            InputStream xslStream = 
                    getServletContext().getResourceAsStream("/book.xsl");
            
            transform(messageDocument, xslStream, out);
            
            out.flush();
            out.close();
            
        } catch (ParserConfigurationException pcException) {
            pcException.printStackTrace();
        }
    }
    
    
    private void transform(Document document, 
            InputStream xslStream, PrintWriter out) {
        
        
        try {
            Source xmlSource = new DOMSource(document);
            
            Source xslSource = new StreamSource(xslStream);
            
            Result result = new StreamResult(out);
            
            
            TransformerFactory transformerFactory = 
                    TransformerFactory.newInstance();
            
            Transformer transformer = transformerFactory.newTransformer(xslSource);
            
            transformer.transform(xmlSource, result);
        } catch (TransformerException transformerException) {
            transformerException.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

<%-- 
    Document   : books
    Created on : Dec 23, 2014, 9:19:11 PM
    Author     : MdMahadiHasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="com.mahadihasan.bookstore.*, com.mahadihasan.bookstore.servlet.*, java.util.*" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book List</title>
        <link rel="stylesheet" href="styles.css" type="text/css"
    </head>
    <body>
        
        <p class="bigFont">Available Books</p>
        <p class="bold">Click a link to view book information</p>
        
        <p>
            
            <%
            TitlesBean titlesBean = new TitlesBean();
            List titles = titlesBean.getTitles();
            BookBean currenBook;
            
            session.setAttribute("titles", titles);
            Iterator iterator = titles.iterator();
            
            while (iterator.hasNext()) {
                currenBook = (BookBean) iterator.next();
            
            
            %>
            
            
            <span class="bold">
                
                <a href="displayBook?isbn<%= currenBook.getISBN()%>">
                    <%= currenBook.getTitle() + ", "+ 
                            currenBook.getEditionNumber()+"e" %>
                </a>
            </span><br/>
            
            <%
            }
            %>
        </p>
    </body>
</html>

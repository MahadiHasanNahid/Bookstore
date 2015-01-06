<?xml version = "1.0" ?>

<xsl:stylesheet xmlns:xsl ="http://www.w3.org/1999/XSL/Transform"
 version = "1.0">
    
<xsl:output method ="xml" omit-xml-declaration ="no" 
 indent = "yes"doctype-system =
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
 doctype-public = "-//W3C//DTD XHTML 1.0 Strict//EN"/>


<xsl:template match ="product">

<html>

    <head>
        <!-- obtain book title from JSP to place in title -->
        <title>
            <xsl:value-of select = "title"/>
        </title>

        <link rel = "stylesheet" href ="styles.css"
        type = "text/css"/>
    </head>


    <body>
        <p class ="bigFont"><xsl:value-of select ="title"/></p>

        <table>
            <tr>
                <!-- create table cell for product image -->
                <td rowspan = "5"> <!-- cell spans 5 rows -->
                    <img border = "thin solid black" src =
                    "images/{imageFile }"alt = "{title }"/>
                </td>

                <!-- create table cells for price in row 1 -->
                <td class = "bold">Price:</td>

                <td>
                    <xsl:value-of select ="price"/>
                </td>
            </tr>
            
            <tr>
                <!-- create table cells for ISBN in row 2 -->
                <td class ="bold">ISBN #:</td>

                <td>
                    <xsl:value-of select = "isbn"/>
                </td>
            </tr>

            <tr>
                <!-- create table cells for edition in row 3 -->
                <td class ="bold">Edition:</td>

                <td>
                    <xsl:value-of select = "editionNumber"/>
                </td>
            </tr>

            <tr>
                <!-- create table cells for copyright in row 4 -->
                <td class = "bold">Copyright:</td>

                <td>
                    <xsl:value-of select ="copyright"/>
                </td>
            </tr>

            <tr>
                <!-- create Add to Cart button in row 5 -->
                <td>
                    <form method = "post"action ="addToCart">
                        <input type = "submit" value = "Add to Cart"/>
                    </form>
                </td>

                <!-- create View Cart button in row 5 -->
                <td>
                    <form method = "get" action = "viewCart.jsp">
                        <input type = "submit" value = "View Cart"/>
                    </form>
                </td>
            </tr>
     </table>

     </body>

 </html> 

 </xsl:template>

 </xsl:stylesheet>
   
package com.mahadihasan.bookstore;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;

/**
 *
 * @author MdMahadiHasan
 */
public class TitlesBean implements Serializable {
    private Connection connection;
    private PreparedStatement titlesQuery;
    
    public TitlesBean () {
        try {
            InitialContext ic = new InitialContext();
            DataSource source = (DataSource) ic.lookup(""
                    + "java:comp/env/jdbc/books");
            
            connection = source.getConnection();
            
            titlesQuery = 
                    connection.prepareStatement(
                            "");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }catch(NamingException namingException) {
            namingException.printStackTrace();
        }
    }
    
    public List getTitles() {
        List titlesList = new ArrayList();
        
        try {
            ResultSet results = titlesQuery.executeQuery();
            
            while (results.next()) {
                BookBean book = new BookBean();
            }
        } catch (Exception e) {
        }
    }
}

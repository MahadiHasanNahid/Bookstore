package com.mahadihasan.bookstore;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MdMahadiHasan
 */
public class TitlesBean implements Serializable {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bookstore"; 
    static final String USER = "root";
    static final String PASS = "";
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    

    private PreparedStatement titlesQuery;
    
    
    public TitlesBean () {
        try {
            getConnection();
            System.out.println("connected----------");
            titlesQuery = 
                    connection.prepareStatement(
                            "SELECT isbn, title, editionNumber, "
                                    + "copyright, publisherID, imageFile, price "
                                    + "FROM titles ORDER BY title");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        TitlesBean t = new TitlesBean();
//        
//    }
    public void getConnection() {
        try {
            connection = null;
            statement = null;
            result = null;
            Class.forName(JDBC_DRIVER);
            System.out.println("connecting ");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Can not connect to DB");
        }
    }
    
    
    public void close() {
        if (connection != null && statement != null && result != null) {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException ex) {
            }
        }
    }
    
    
    public List getTitles() {
        List titlesList = new ArrayList();
        
        try {
            ResultSet results = titlesQuery.executeQuery();
            
            while (results.next()) {
                BookBean book = new BookBean();
                book.setISBN( results.getString( "isbn") );
                book.setTitle(results.getString("title"));
                book.setEditionNumber(results.getInt("editionNumber"));
                book.setCopyright(results.getString("copyright"));
                book.setPublisherId(results.getInt("publisherID"));
                book.setImageFile(results.getString("imageFile"));
                book.setPrice(results.getDouble("price"));
                
                titlesList.add(book);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally{
          return titlesList;
        }
    }
    
    @Override
    protected void finalize() {
        try {
            connection.close();
        } catch(SQLException sQLException) {
            sQLException.printStackTrace();
        } 
    }
    
    
}

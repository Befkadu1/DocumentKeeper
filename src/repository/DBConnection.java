/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import documentkeeper.model.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Joel
 */
public class DBConnection {
    
    Connection connection;
    Statement st;
    String url = "jdbc:derby://localhost:1527/documentkeeper;create=true;user=root;password=root";
    String selectQuery = "Select * from users";
    String insertQuery = "INSERT INTO users (username) VALUES ('TestUser') ";

    String getAllCategoriesQuery = "select * from category";
    

    String createFolderQuery = "INSERT INTO folders (name,description) VALUES (?, ?)";

    public DBConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connection = (Connection) DriverManager.getConnection(url);
            st = (Statement) connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error connecting to database " + ex.getMessage());
        } catch (Exception except){
            except.printStackTrace();
        }
    }
    
    public ArrayList<Category> getAllCategories(){
        
            ArrayList<Category> category = new ArrayList();
        
          try {
            ResultSet result = st.executeQuery(getAllCategoriesQuery);
            while (result.next()) {
                int id = Integer.parseInt(result.getString(1));
                String name = result.getString(2);
                category.add(new Category(1,name));
            }
        } catch (SQLException ex) {
            System.out.println("Error in sql-query: getAllCategories() " + ex.getMessage());
        }
   
          return category;
    }
    
    public void createFolder(String name, String description){
        try {
            PreparedStatement pst = connection.prepareStatement(createFolderQuery);
            pst.setString(1, name);
            pst.setString(2, description);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
    
}

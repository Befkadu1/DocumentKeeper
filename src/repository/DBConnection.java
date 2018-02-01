/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import documentkeeper.model.Category;
import java.sql.Connection;
import java.sql.DriverManager;
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
    String getAllCategoriesQuery = "Select * from category";
    
    public DBConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connection = (Connection) DriverManager.getConnection(url);
            st = (Statement) connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Fel med koppling till databas " + ex.getMessage());
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
            System.out.println("Fel i sql-satsen " + ex.getMessage());
        }
   
          return category;
    }
    
    public ArrayList<String> getUsersFirstname() {
        
        ArrayList<String> users = new ArrayList();
        
        try {
            
            st.executeUpdate(insertQuery);

        } catch (SQLException ex) {
            System.out.println("Fel i sql-satsen " + ex.getMessage());
        }
        
        
        try {
            
            ResultSet result = st.executeQuery(selectQuery);
            while (result.next()) {
                String name = result.getString(1);
                
                users.add(name);
            }
        } catch (SQLException ex) {
            System.out.println("Fel i sql-satsen " + ex.getMessage());
        }
        return users;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

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
    String createFolderQuery = "INSERT INTO folders (name,description) VALUES (?, ?)";
    public DBConnection() {
        
        System.out.println("test");
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
    
    // This is just a proof of concept
    // I added a table with name as only column
    // and a couple of entries to test
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

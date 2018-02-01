package repository;

import documentkeeper.model.Category;
import documentkeeper.model.File;
import documentkeeper.model.Folder;
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
    
    private ArrayList<Folder> getFoldersFromDb(){
        selectQuery = "Select * from folders";
        ArrayList<Folder> folderList = new ArrayList<>();
        try{
            ResultSet result = st.executeQuery(selectQuery);
            
            while (result.next()) {
                Folder folder = new Folder(result.getInt(1), result.getString(2), result.getString(3));
                
                folderList.add(folder);
            }
            
        }catch(Exception e){
            System.out.println("SQL Exception: " + e);
        }
        return folderList;
    }
    
    public ArrayList<Folder> getDataFromDB(){
        ArrayList<Folder> folderList = getFoldersFromDb();
        
        for(Folder f : folderList){
            f.setFileList(getFilesByFolderId(f.getId()));
            f.setCategoryList(getCategoryByFolderId(f.getId()));
        }
        
        return folderList;
    }
    
    private ArrayList<File> getFilesByFolderId(int folderId){
        ArrayList<File> fileList = new ArrayList<>();
        selectQuery = "SELECT * FROM files INNER JOIN Folders_has_files ON Files.idFile = Folders_has_files.idFile WHERE Folders_has_files.idFolder = " + folderId;
        try{
            ResultSet result = st.executeQuery(selectQuery);
             while (result.next()) {
                 File file = new File(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                 fileList.add(file);
            }
            
        }catch(Exception e){
            System.out.println("SQL Exception:  " + e);
        }
        return fileList;
    }
    
    private ArrayList<Category> getCategoryByFolderId(int folderId){
        ArrayList<Category> categoryList = new ArrayList<>();
        selectQuery = "SELECT * FROM Category INNER JOIN Category_has_folders ON Category.idCategory = Category_has_folders.idCategory WHERE Category_has_folders.idFolder = " + folderId;
        try{
            ResultSet result = st.executeQuery(selectQuery);
             while (result.next()) {
                 Category category = new Category(result.getInt(1), result.getString(2));
                 categoryList.add(category);
            }
            
        }catch(Exception e){
            System.out.println("SQL Exception:  " + e);
        }
        return categoryList;
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
    
}

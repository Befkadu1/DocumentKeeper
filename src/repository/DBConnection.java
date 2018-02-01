package repository;

import documentkeeper.model.Category;
import documentkeeper.model.File;
import documentkeeper.model.Folder;
import documentkeeper.model.User;
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
    String getAllUsers = "Select * from users";
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
    
     public ArrayList<Category> getAllCategories(){
        
           ArrayList<Category> category = new ArrayList();
        
          try {
            ResultSet result = st.executeQuery(getAllCategoriesQuery);
                while (result.next()) {
                    int id = Integer.parseInt(result.getString(1));
                    String name = result.getString(2);
                    category.add(new Category(1,name));
                }
            }catch(Exception e){
                    System.out.println("SQL Exception: " + e);
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
    
     public ArrayList<User> getAllUsers(){
        
            ArrayList<User> user = new ArrayList();
        
          try {
            ResultSet result = st.executeQuery(getAllUsers);
            while (result.next()) {
                int id = Integer.parseInt(result.getString(1));
                String username = result.getString(2);
                String password = result.getString(3);
                user.add(new User(id,username, password));
            }
        } catch (SQLException ex) {
            System.out.println("Error in sql-query: getAllCategories() " + ex.getMessage());
        }
   
          return user;
    }
    
}

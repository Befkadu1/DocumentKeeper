package documentkeeper;

import documentkeeper.model.Category;
import documentkeeper.model.File;
import documentkeeper.model.Folder;
import java.util.ArrayList;
import repository.DBConnection;

/**
 * @author wuzoink
 */

public class Logic {
    
    private static Logic instance = null;
    private ArrayList<Folder> folderList = new ArrayList<>();
    private DBConnection db = new DBConnection();
    
    
       private Logic() {
      // Exists only to defeat instantiation.
   }
    
    public static Logic getInstance(){
        if(instance == null){
            instance = new Logic();
        } 
        return instance;
    }
    
    public void fillLists(){
        db.getDataFromDB();
    }
    
    public ArrayList<Folder> getFolderList(){
        return folderList;
    }
    
    public Folder getFolderById(int folderId){
        Folder selectedFolder = new Folder();
        
        for(Folder f : folderList){
            if(f.getId() == folderId){
                selectedFolder = f;
            }  
        }
        return selectedFolder;
    }
    
    public File getFileById(int fileId){
        File selectedFile = new File();
        
        for(Folder folder : folderList){
            ArrayList<File> fileList = folder.getFileList();
            for(File file : fileList){
                if(file.getId() == fileId){
                    selectedFile = file;
                }
            }
        }
        return selectedFile;  
    }
    public ArrayList<Category> getCategories(){
    return db.getAllCategories();
    }
    public void createFolder(String name,String description){
        db.createFolder(name, description);
    }
    
}

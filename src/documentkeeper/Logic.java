package documentkeeper;

import documentkeeper.model.Folder;
import java.util.ArrayList;

/**
 * @author wuzoink
 */

public class Logic {
    
    private static Logic instance = null;
    private ArrayList<Folder> folderList = new ArrayList<>();
    
    
       private Logic() {
      // Exists only to defeat instantiation.
   }
    
    public static Logic getInstance(){
        if(instance == null){
            instance = new Logic();
        } 
        return instance;
    }
    
    public ArrayList<Folder> getFolderList(){
        return folderList;
    }
    
    public Folder getFolderById(int folderId){
        Folder selectedFolder = new Folder();
        
        for(Folder f : folderList){
            int id = f.getId();
            if(id == folderId){
                selectedFolder = f;
            }  
        }
        return selectedFolder;
    }
    
}

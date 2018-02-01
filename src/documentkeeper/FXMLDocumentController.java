package documentkeeper;

import documentkeeper.model.File;
import documentkeeper.model.Folder;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 *
 * @author Joel
 */

public class FXMLDocumentController implements Initializable {
    
    private Logic logic;
    
    @FXML
    private TreeView<String> treeNav;
    
    private void fillTreeView(){
        TreeItem<String> treeRoot = new TreeItem<>("Folders");
        
        for(Folder folder: logic.getFolderList()){
            TreeItem<String> folderNode = new TreeItem<>(folder.getName());
            
            for(File file : folder.getFileList()){
                TreeItem<String> fileNode = new TreeItem<>(file.getName());
                folderNode.getChildren().add(fileNode);
            }
 
           treeRoot.getChildren().add(folderNode);
           treeRoot.setExpanded(true);
        }
        
        treeNav.setRoot(treeRoot);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logic = Logic.getInstance();
        fillTreeView();
    }    
    
}

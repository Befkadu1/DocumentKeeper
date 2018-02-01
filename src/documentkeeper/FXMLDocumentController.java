package documentkeeper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;

/**
 *
 * @author Joel
 */

public class FXMLDocumentController implements Initializable {
    
    private Logic logic;
    
    @FXML
    private TreeView treeNav;
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logic = Logic.getInstance();


        
    }    
    
}

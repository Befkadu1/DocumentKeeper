package documentkeeper;

import documentkeeper.model.Category;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import repository.DBConnection;

/**
 *
 * @author Joel
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBConnection c = new DBConnection();
        System.out.println("klajskdlasd");
        System.out.println(c.getAllCategories());
        
    }    
    
}

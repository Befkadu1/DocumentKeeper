/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documentkeeper;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import repository.DBConnection;

/**
 *
 * @author Leoga
 */
public class LoginController implements Initializable {

    private DBConnection dbConnection;
    
    @FXML
    private JFXTextField docUsername;
    
    @FXML
    private  JFXPasswordField docPassword;
    
    @FXML
    private Label docError;
    
   @FXML
    private void login(ActionEvent event) {
        try {
            if (docUsername.getText().trim().length() > 0 && docPassword.getText().length() > 0) {
             //kod ska in. väntar på User class.    
           
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            docError.setText("Incorrect username or password.");
            docPassword.setText("");
            System.out.println("Incorrect username or password.");

        }
    }

    @Override
  // kod ska in

   // @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

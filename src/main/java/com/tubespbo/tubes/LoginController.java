/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.tubespbo.tubes;

import com.tubespbo.tubes.Database.databaseConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author akhda
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
    
    @FXML
    private TextField usernameF, passwordF;
    
    @FXML
    private void Login(){
        String username = usernameF.getText();
        String password = passwordF.getText();
        
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        
        if (username.isEmpty() && password.isEmpty()) {
            showAlert("Username or Password cannot be empty!");
        } else {
            showAlert("Welcome, " + username + "!");
        }
    }
    
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Status");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.tubespbo.tubes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author akhda
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }
    
    private TextField searchf;
    
    @FXML
    private void search(){
        String searchValue = searchf.getText();
        System.out.println(searchValue);
    }
    
    
}

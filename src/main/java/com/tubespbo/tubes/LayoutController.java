/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.tubespbo.tubes;

import com.tubespbo.tubes.Database.PlaylistDAO;
import com.tubespbo.tubes.Database.PlaylistModel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author akhda
 */
public class LayoutController implements Initializable {
    
    @FXML
    private StackPane contentArea;
    
    private GridPane grid;

    private PlaylistDAO playlistDAO;
    
    public LayoutController() {
        this.playlistDAO = new PlaylistDAO();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tubespbo/tubes/home.fxml"));
            Parent fxml = loader.load();

            // HomeController homeController = loader.getController(); // Tidak perlu memanggil initialize()

            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);

            System.out.println("Home page loaded and initialized!");
        } catch (IOException ex) {
            System.out.println("Error Load Page Home: " + ex.getMessage());
        }
    }

    public void home(javafx.event.ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tubespbo/tubes/home.fxml"));
            Parent fxml = loader.load();

            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);

            System.out.println("Home page loaded and initialized!");
        } catch (IOException ex) {
            System.out.println("Error Load Page Home: " + ex.getMessage());
        }
    }
    public void music(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("music.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    public void playlist(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("playlist.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    public void premium(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("premium.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
}

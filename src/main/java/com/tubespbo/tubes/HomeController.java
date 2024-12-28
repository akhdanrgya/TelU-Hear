package com.tubespbo.tubes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HomeController {
    @FXML
    private BorderPane contentPane; // pastikan ini sesuai dengan fx:id di fxml
    @FXML
    private Button homeButton;
    @FXML
    private Button musicButton;
    @FXML
    private Button playlistButton;
    @FXML
    private Button premiumButton;

    @FXML
    private void initialize() {
        // tambahkan event handler ke tombol-tombol
        homeButton.setOnAction(event -> loadPage("home.fxml"));
        musicButton.setOnAction(event -> loadPage("music.fxml"));
        playlistButton.setOnAction(event -> loadPage("playlist.fxml"));
        premiumButton.setOnAction(event -> loadPage("premium.fxml"));
    }

    private void loadPage(String fxmlFile) {
        try {
            // load fxml dan set ke center pane
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Node node = loader.load();
            contentPane.setCenter(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





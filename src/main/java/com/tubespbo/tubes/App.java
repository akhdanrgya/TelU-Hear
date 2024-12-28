package com.tubespbo.tubes;

import com.tubespbo.tubes.Database.SongDAO;
import com.tubespbo.tubes.Database.SongModel;
import com.tubespbo.tubes.Database.databaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        stage.show();
                databaseConnection.connect();
        
        SongDAO songDAO= new SongDAO(databaseConnection.getConnection());
        
        List<SongModel> songs = songDAO.getAllSongs();
        
        for(SongModel song : songs){
            System.out.println(song.getJudul());
        }  
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
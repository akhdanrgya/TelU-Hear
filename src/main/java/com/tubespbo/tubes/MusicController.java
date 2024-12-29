 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.tubespbo.tubes;

import javafx.fxml.FXML;
import com.tubespbo.tubes.Database.SongDAO;
import com.tubespbo.tubes.Database.SongModel;
import com.tubespbo.tubes.Database.databaseConnection;


import java.util.List;
import javafx.scene.control.Label;

public class MusicController {
    
    @FXML
    public void initialize() {
        
    }
    
    public static List<SongModel> fetchSongTitles() {
        databaseConnection.connect();
        
        SongDAO songDAO = new SongDAO(databaseConnection.getConnection());
        
        return songDAO.getAllSongs();
    }
}

package com.tubespbo.tubes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import com.tubespbo.tubes.Database.PlaylistDAO;
import com.tubespbo.tubes.Database.PlaylistModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

public class HomeController implements Initializable {

    @FXML
    private GridPane grid;

    private PlaylistDAO playlistDAO;
    
    private AnchorPane playlistAnchor;

    public HomeController() {
        this.playlistDAO = new PlaylistDAO();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadPlaylists();
        System.out.println("init home");
    }

    private void loadPlaylists() {
        List<PlaylistModel> playlists = playlistDAO.getAllPlaylists();
        int column = 0;
        int row = 0;

        System.out.println("Jumlah playlist di controller: " + playlists.size());

        try {
            for (int i = 0 ; i < playlists.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/tubespbo/tubes/playlistCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                PlaylistCardController playlistController = fxmlLoader.getController();
                playlistController.setPlaylistData(playlists.get(i));

                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));

                if (column == 3) {
                    column = 0;
                    row++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

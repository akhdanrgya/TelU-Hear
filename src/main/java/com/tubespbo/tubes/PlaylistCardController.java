package com.tubespbo.tubes;

import com.tubespbo.tubes.Database.PlaylistModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlaylistCardController {

    @FXML
    private Label playlistNameLabel;

    @FXML
    private ImageView playlistImage;

    private PlaylistModel playlist;

    public void setPlaylistData(PlaylistModel playlist) {
        this.playlist = playlist;
        playlistNameLabel.setText(playlist.getPlaylist_name());

        // Pastikan gambar ditemukan dan valid
        String imagePath = playlist.getImage();
        if (imagePath != null && !imagePath.isEmpty()) {
            try {
                Image image = new Image(getClass().getResourceAsStream(imagePath));
                playlistImage.setImage(image);
            } catch (Exception e) {
                // Jika gambar tidak ditemukan, set gambar default
                playlistImage.setImage(new Image(getClass().getResourceAsStream("/com/tubespbo/tubes/default-image.png")));
            }
        } else {
            // Set gambar default jika path kosong atau null
            playlistImage.setImage(new Image(getClass().getResourceAsStream("/com/tubespbo/tubes/default-image.png")));
        }
    }
}

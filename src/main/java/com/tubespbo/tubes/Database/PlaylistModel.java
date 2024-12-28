package com.tubespbo.tubes.Database;

/**
 *
 * @author akhda
 */
public class PlaylistModel {
    private int id;
    private int id_user;
    private String playlist_name;
    private String image;

    // Constructor default
    public PlaylistModel() {
    }

    // Constructor dengan parameter
    public PlaylistModel(int id, int id_user, String playlist_name, String image) {
        this.id = id;
        this.id_user = id_user;
        this.playlist_name = playlist_name;
        this.image = image;
    }

    // Getter dan Setter untuk id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter dan Setter untuk id_user
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    // Getter dan Setter untuk playlist_name
    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }
    
    // Getter dan Setter untuk image
    public String getImage(){
        return image;
    }
    
    public void setImage(String image){
        this.image = image;
    }

    // Method toString untuk debugging
    @Override
    public String toString() {
        return "PlaylistModel{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", playlist_name='" + playlist_name + '\'' +
                '}';
    }
}

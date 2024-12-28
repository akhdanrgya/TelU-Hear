/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tubespbo.tubes.Database;

/**
 *
 * @author akhda
 */
public class PlaylistModel {
    private int id;
    private int id_user;
    private String playlist_name;
    
    public PlaylistModel(){
        
    }
    
    public PlaylistModel(int id, int id_user, String playlist_name){
        this.id = id;
        this.id_user = id_user;
        this.playlist_name = playlist_name;
    }
}

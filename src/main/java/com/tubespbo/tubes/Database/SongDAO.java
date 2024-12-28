/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tubespbo.tubes.Database;

/**
 *
 * @author akhda
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SongDAO {
    public List<String> getSongs(int page, int pageSize) {
        List<String> songs = new ArrayList<>();
        String query = "SELECT judul, artist FROM music LIMIT ? OFFSET ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            int offset = (page - 1) * pageSize;
            stmt.setInt(1, pageSize);
            stmt.setInt(2, offset);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String song = rs.getString("title") + " - " + rs.getString("artist");
                songs.add(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }
}

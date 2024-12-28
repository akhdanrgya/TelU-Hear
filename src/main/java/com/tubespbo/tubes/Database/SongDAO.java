package com.tubespbo.tubes.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {
    private Connection connection;

    public SongDAO(Connection connection) {
        this.connection = connection;
    }

    public List<SongModel> getAllSongs() {
        List<SongModel> songs = new ArrayList<>();
        String query = "SELECT * FROM music";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                SongModel song = new SongModel(
                        rs.getInt("id"),
                        rs.getString("judul"),
                        rs.getString("artist"),
                        rs.getString("genre"),
                        rs.getString("duration")
                );
                songs.add(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return songs;
    }
}

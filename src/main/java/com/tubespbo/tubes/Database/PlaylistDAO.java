package com.tubespbo.tubes.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akhda
 */

public class PlaylistDAO {
    private final Connection connection;

    public PlaylistDAO() {
        this.connection = databaseConnection.getConnection();
    }

    public boolean addPlaylist(PlaylistModel playlist) {
        String query = "INSERT INTO playlist (id_user, playlist_name, image) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, playlist.getId_user());
            stmt.setString(2, playlist.getPlaylist_name());
            stmt.setString(3, playlist.getImage());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error saat menambah playlist: " + e.getMessage());
            return false;
        }
    }

    public List<PlaylistModel> getAllPlaylists() {
        List<PlaylistModel> playlists = new ArrayList<>();
        String query = "SELECT * FROM playlist";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PlaylistModel playlist = new PlaylistModel(
                        rs.getInt("id"),
                        rs.getInt("id_user"),
                        rs.getString("playlist_name"),
                        rs.getString("image")
                );
                playlists.add(playlist);
            }
        } catch (SQLException e) {
            System.err.println("Error saat mengambil playlist: " + e.getMessage());
        }
        return playlists;
    }


    public boolean updatePlaylistName(int id, String newName) {
        String query = "UPDATE playlist SET playlist_name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error saat mengupdate playlist: " + e.getMessage());
            return false;
        }
    }

    public boolean deletePlaylist(int id) {
        String query = "DELETE FROM playlist WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error saat menghapus playlist: " + e.getMessage());
            return false;
        }
    }
}

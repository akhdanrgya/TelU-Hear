/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.tubespbo.tubes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import com.tubespbo.tubes.Database.SongDAO;


import java.util.List;

public class MusicController {
    @FXML
    private Pagination pagination;

    private final SongDAO songDAO = new SongDAO();
    private final int pageSize = 5;

    @FXML
    public void initialize() {
        int totalSongs = 20;
        int pageCount = (int) Math.ceil((double) totalSongs / pageSize);

        pagination.setPageCount(pageCount);
        pagination.setCurrentPageIndex(0);

        pagination.setPageFactory(this::createPage);
    }

    private Label createPage(int pageIndex) {
        List<String> songs = songDAO.getSongs(pageIndex + 1, pageSize);

        StringBuilder content = new StringBuilder();
        for (String song : songs) {
            content.append(song).append("\n");
        }

        Label label = new Label(content.toString());
        label.setStyle("-fx-font-size: 14px; -fx-text-fill: #4987b9;");
        return label;
    }
}

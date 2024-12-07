package com.tubespbo.tubes;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    
    private void cekdb(){
                try {
            if (databaseConnection.getConnection() != null) {
                System.out.println("Berhasil terkoneksi ke database!");
            } else {
                System.out.println("Gagal terkoneksi ke database.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
        cekdb();
    }
    
}

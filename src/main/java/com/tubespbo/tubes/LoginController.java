package com.tubespbo.tubes;

import com.tubespbo.tubes.Database.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private TextField usernameF, passwordF;

    @FXML
    private Label usernameLabel;

    private UserDAO userDAO;

    public LoginController() {
        this.userDAO = new UserDAO();
    }

    @FXML
    private void initialize() {

    }

    @FXML
    private void Login() {
        String username = usernameF.getText();
        String password = passwordF.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Username dan Password tidak boleh kosong!");
        } else {
            boolean isValid = userDAO.validateUser(username, password);
            if (isValid) {
                showAlert("Login Berhasil! Selamat datang, " + username + "!");
//                usernameLabel.setText(username);
                goToHome();
            } else {
                showAlert("Login Gagal! Username atau Password salah.");
            }
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Status");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void goToHome() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tubespbo/tubes/layout.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) usernameF.getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("TelU Hear");
            stage.show();
        } catch (Exception e) {
            System.err.println("Error saat pindah halaman: " + e.getMessage());
        }
    }
}

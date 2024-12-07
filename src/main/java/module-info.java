module com.tubespbo.tubes {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tubespbo.tubes to javafx.fxml;
    exports com.tubespbo.tubes;
}

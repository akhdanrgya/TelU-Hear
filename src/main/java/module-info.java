module com.tubespbo.tubes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.tubespbo.tubes to javafx.fxml;
    exports com.tubespbo.tubes;
}

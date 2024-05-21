module com.example.bunker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bunker to javafx.fxml;
    exports com.example.bunker;
}
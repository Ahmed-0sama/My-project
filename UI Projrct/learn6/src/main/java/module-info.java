module com.example.learn6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.learn6 to javafx.fxml;
    exports com.example.learn6;
}
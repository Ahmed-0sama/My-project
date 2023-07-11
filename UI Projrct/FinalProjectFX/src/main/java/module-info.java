module com.example.finalprojectfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires ojdbc6;
    requires org.xerial.sqlitejdbc;


    opens com.example.finalprojectfx to javafx.fxml;
    exports com.example.finalprojectfx;
}
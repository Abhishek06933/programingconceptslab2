module com.example.lab2pgc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.lab2pgc to javafx.fxml;
    exports com.example.lab2pgc;
}
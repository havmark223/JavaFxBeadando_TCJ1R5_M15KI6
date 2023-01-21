module com.example.javafxbea {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.javafxbea to javafx.fxml;
    exports com.example.javafxbea;
    exports com.example.javafxbea.DAO;
    exports com.example.javafxbea.Modells;
    opens com.example.javafxbea.DAO to javafx.fxml;
}
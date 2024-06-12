module com.math {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.sql;
    requires java.desktop;

    opens com.math to javafx.fxml;
    exports com.math;
}

module com.math {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires javafx.media;
    requires java.sql;
    requires java.desktop;

    opens com.math to javafx.fxml;
    exports com.math;
}

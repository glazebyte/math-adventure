module com.math {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.math to javafx.fxml;
    exports com.math;
}

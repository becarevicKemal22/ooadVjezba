module com.example.lv09 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;
    requires java.sql;

    opens com.example.lv09.controller to javafx.fxml;
    opens com.example.lv09 to javafx.fxml;
    exports com.example.lv09;

}
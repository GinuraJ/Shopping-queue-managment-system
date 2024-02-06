module com.example.gui_cw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gui_cw to javafx.fxml;
    exports com.example.gui_cw;
}
module com.cenfotec.entregable1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.cenfotec.entregable1 to javafx.fxml;
    exports com.cenfotec.entregable1;
}
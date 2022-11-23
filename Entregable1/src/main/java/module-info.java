module com.cenfotec.entregable1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;


    opens com.cenfotec.entregable1 to javafx.fxml;
    exports com.cenfotec.entregable1;
    exports com.cenfotec.entregable1.view;
    opens com.cenfotec.entregable1.view to javafx.fxml;
    exports com.cenfotec.entregable1.dao.mysql;
    opens com.cenfotec.entregable1.dao.mysql to javafx.fxml;
}
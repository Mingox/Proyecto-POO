package com.cenfotec.entregable1.view;

import com.cenfotec.entregable1.Main;
import com.cenfotec.entregable1.dao.DAOException;
import com.cenfotec.entregable1.dao.mysql.DatabaseConection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProyectoView {

    @FXML
    private TableColumn<?, ?> Categoria_P;

    @FXML
    private TableColumn<?, ?> FecCrea_P;

    @FXML
    private TableColumn<?, ?> Inv_P;

    @FXML
    private TableColumn<?, ?> Media_P;

    @FXML
    private TableColumn<?, ?> Nombre_P;

    @FXML
    private TableColumn<?, ?> UltMod_P;

    @FXML
    private Button buttonAsignarRol;

    @FXML
    private Button btn02Proj;

    @FXML
    private Button btn03Proj;

    @FXML
    private Button btn04Proj;

    @FXML
    private Button btnNewP;

    @FXML
    private TableView<?> tabInveP;

    @FXML
    private TableView<?> tabMediaP;

    @FXML
    private TableView<?> tabProyecto;

    @FXML
    private Label avisoCambioRol;

    private nuevoProyectoView controllerNuevoProyecto;

/*
    @FXML
    void click(ActionEvent event) {
    stage.show();
    stage.close();
    }

    @FXML
    void handleButtonClick(ActionEvent event) {

    }

    public void init(String text, Stage stage, nuevoProyectoView nuevoProyectoView) {
    btn02Proj.setText(text);
    this.stage = stage;
    this.controllerNuevoProyecto=controllerNuevoProyecto;
    }
*/
    public void nuevoProyecto(ActionEvent a) throws IOException {
        Stage old = (Stage) btnNewP.getScene().getWindow();
        old.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("nuevo_proyecto-view.fxml"));
        Scene nuevoProyecto = new Scene(fxmlLoader.load(), 570, 350);
        Stage stage = new Stage();
        stage.setTitle("Nuevo Proyecto");
        stage.setScene(nuevoProyecto);
        nuevoProyecto.getWindow().setWidth(522);
        nuevoProyecto.getWindow().setHeight(426);
        stage.show();
    }

    public void click(){

    }
    public void asignarRol() throws DAOException {
        String updateRol = "UPDATE usuarios SET rol = ? WHERE rol = ?";
        DatabaseConection connectNow = new DatabaseConection();
        Connection connectDB = connectNow.getConection();
        PreparedStatement stat = null;
        try{
            stat = connectDB.prepareStatement(updateRol);
            stat.setString(1, "Colaborador");
            stat.setString(2, "Pendiente");
            stat.executeUpdate();
            avisoCambioRol.setText("Los usuarios pendientes ahora son Colaboradores");

        }catch (SQLException e){
            throw new DAOException("Error sql", e);
        } finally {
            if (stat != null){
                try {
                    stat.close();
                }catch (SQLException e){
                    throw new DAOException("Error sql", e);
                }
            }

        }
    }

}//Fin programa

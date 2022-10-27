package com.cenfotec.entregable1.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
    private Button btn01Proj;

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

    private nuevoProyectoView controllerNuevoProyecto;
    private Stage stage;

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

}//Fin programa

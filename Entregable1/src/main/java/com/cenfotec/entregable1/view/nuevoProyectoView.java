package com.cenfotec.entregable1.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class nuevoProyectoView {

    @FXML
    private MenuBar Cat_Np;

    @FXML
    private CheckMenuItem Nv_Np;

    @FXML
    private CheckMenuItem accionT_Np;

    @FXML
    private Button btnCrearP;

    @FXML
    private DatePicker creacion_Np;

    @FXML
    private CheckMenuItem dae_Np;

    @FXML
    private CheckMenuItem ic_Np;

    @FXML
    private CheckMenuItem jdd_Np;

    @FXML
    private CheckMenuItem pea_Np;

    @FXML
    private TextField txtNom_Np;

    @FXML
    private DatePicker ultmodif_Np;

    @FXML
    private CheckMenuItem vgd_Np;

    @FXML
    void click(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/proyecto-view.fxml"));
        Parent root = loader.load();
        ProyectoView controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.init(txtNom_Np.getText(), stage, this);
        stage.show();
        stage.close();
    }

}

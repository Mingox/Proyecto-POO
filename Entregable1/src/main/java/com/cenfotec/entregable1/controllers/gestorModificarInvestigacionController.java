package com.cenfotec.entregable1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class gestorModificarInvestigacionController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button btnModificar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnVolver;

    @FXML
    private Label labelError;
    @FXML
    private TextField txtNombreProyecto;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtSub;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtTema;
    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtModificar;

    Connection con;
    PreparedStatement pst;


    void modificar(ActionEvent event) throws Exception {



        String nombreModificacion = txtModificar.getText();
        String nombreInvestigacion = txtNombreProyecto.getText();
        String titulo = txtTitulo.getText();
        String subtitulo = txtSub.getText();
        String categoria = txtCategoria.getText();
        String tema = txtTema.getText();
        String autor = txtAutor.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bgv9uf1md2cfkytodvqw-mysql.services.clever-cloud.com:3306/proyecto-POO", "up173wgembmsauji", "qTsWjPIFNDEPjYOfw5yx");
            pst = con.prepareStatement("UPDATE `proyectopoo`.`investigaciones` SET `Titulo` = ?,`Subtitulo` = ? ,`Categoria` = ?,`Tema` = ?,`Autor` = ?, `NombreInvestigacion` = ?, WHERE `Proyecto` = ?;");
            pst.setString(1, titulo);
            pst.setString(2, subtitulo);
            pst.setString(3, categoria);
            pst.setString(4, tema);
            pst.setString(5, autor);
            pst.setString(6, nombreInvestigacion);
            pst.setString(7, nombreModificacion);


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

        void borrar(ActionEvent event) throws Exception {

            String nombreModificacion = txtModificar.getText();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectopoo", "root", "fenix");
                pst = con.prepareStatement("DELETE FROM `proyectopoo`.`investigaciones` WHERE `Proyecto` = ?;");
                pst.setString(1, nombreModificacion);

            } catch (ClassNotFoundException | SQLException e) {
                labelError.setText("Recuerde rellenar todos los espacios.");
            }

    }

    public void switchToScenePaginaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,403,314);
        stage.setScene(scene);
        stage.show();
    }

}
package com.cenfotec.entregable1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controlador_AgregarMedia {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnAgregar;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField txtInvestigacion;
    @FXML
    private TextField txtAutoria;
    @FXML
    private TextField txtMedia;

    Connection con;
    PreparedStatement pst;

    public void switchToScenePaginaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,403,314);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void agregar(ActionEvent event) throws IOException {

        String NombreInvestigacion = txtInvestigacion.getText();
        String Autoria = txtAutoria.getText();
        String Media = txtMedia.getText();
        String fechaCreacion = new SimpleDateFormat("dd-MM-yyyy").format(new Date());




        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectopoo", "root", "fenix");
            pst = con.prepareStatement("Insert into proyectopoo.media(Autor,Archivo,Fecha,Investigacion)values(?,?,?,?)");
            pst.setString(1, Autoria);
            pst.setString(2, Media);
            pst.setString(3, fechaCreacion);
            pst.setString(4, NombreInvestigacion);
            int status = pst.executeUpdate();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,403,314);
        stage.setScene(scene);
        stage.show();

    }
}

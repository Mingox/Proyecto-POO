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

public class Controlador_AgregarInvestigacion {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtnombreProyecto;
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

        String NombreProyecto = txtnombreProyecto.getText();
        String titulo = txtTitulo.getText();
        String txtsub = txtSub.getText();
        String txtcategoria = txtCategoria.getText();
        String txttema = txtTema.getText();
        String txtautor = txtAutor.getText();
        String fechaInicio = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String fechaModificacion = new SimpleDateFormat("dd-MM-yyyy").format(new Date());




        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectopoo", "root", "fenix");
            pst = con.prepareStatement("UPDATE `proyectopoo`.`investigaciones` SET `Titulo` = ?,`Subtitulo` = ? ,`Categoria` = ?,`Tema` = ?,`Autor` = ?,`FechaInicio` = ?,`FechaModificacion` = ? WHERE `Proyecto` = ?;");
            pst.setString(1, titulo);
            pst.setString(2, txtsub);
            pst.setString(3, txtcategoria);
            pst.setString(4, txttema);
            pst.setString(5, txtautor);
            pst.setString(6, fechaInicio);
            pst.setString(7, fechaModificacion);
            pst.setString(8, NombreProyecto);
            int status = pst.executeUpdate();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectopoo","root","fenix");
            pst = con.prepareStatement("Insert into proyectopoo.media(Investigacion)values(?)");
                    pst.setString(1,titulo);
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

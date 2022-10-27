package com.cenfotec.entregable1.view;

import com.cenfotec.entregable1.dao.mysql.DatabaseConection;
import com.cenfotec.entregable1.Main;
import com.cenfotec.entregable1.dao.DAOException;
import com.cenfotec.entregable1.dao.UsuarioDAO;
import com.cenfotec.entregable1.dao.mysql.MYSQLUsuarioDAO;
import com.cenfotec.entregable1.modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;


public class LoginView {
    @FXML
    private Button loginButton;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Label infoLabel;

    public void loginButtonAction(ActionEvent e) throws DAOException {
        if (userName.getText().isBlank() == false && password.getText().isBlank() == false){

            validarLogin();

        }else {
            infoLabel.setText("Por favor ingrese ambos campos");
        }
    }

    public void signupButtonAction(ActionEvent e) throws  IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("registro.fxml"));
        Scene registro = new Scene(fxmlLoader.load(), 570, 350);
        stage.setTitle("Registro");
        stage.setScene(registro);
        registro.getWindow().setWidth(350);
        registro.getWindow().setHeight(550);
        stage.show();

    }





    public void validarLogin() throws DAOException {
        DatabaseConection connectNow = new DatabaseConection();
        Connection connectDB = connectNow.getConection();

        UsuarioDAO dao = new MYSQLUsuarioDAO(connectDB);
        String data = userName.getText();

        try{
            Usuario user = dao.obtener(data);
            if (userName.getText().equals(user.getUserName()) && password.getText().equals(user.getPassword())) {
                if (user.getRol().equals("pendiente")){
                    mostrarPantallaDeEspera();
                }else if (user.getRol().equals("Gestor")){
                    infoLabel.setText("Ingresó correctamente");
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("proyecto-view-gestor.fxml"));
                    Scene proyecto = new Scene(fxmlLoader.load(), 570, 350);
                    stage.setTitle("Proyectos");
                    stage.setScene(proyecto);
                    proyecto.getWindow().setWidth(830);
                    proyecto.getWindow().setHeight(615);
                    stage.show();
                }
                else {
                    infoLabel.setText("Ingresó correctamente");
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("proyecto-view.fxml"));
                    Scene proyecto = new Scene(fxmlLoader.load(), 570, 350);
                    stage.setTitle("Proyectos");
                    stage.setScene(proyecto);
                    proyecto.getWindow().setWidth(830);
                    proyecto.getWindow().setHeight(615);
                    stage.show();


                }
            } else {
                infoLabel.setText("Datos incorrectos");
            }

        }catch (DAOException e){
            infoLabel.setText("Datos incorrectos");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void mostrarPantallaDeEspera() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("espera.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 378, 200);
        Stage stage = new Stage();
        stage.setTitle("Espera");
        stage.setScene(scene);
        stage.show();
    }




}
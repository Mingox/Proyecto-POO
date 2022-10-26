package com.cenfotec.entregable1.view;

import com.cenfotec.entregable1.DatabaseConection;
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
    public void validarLogin() throws DAOException {
        DatabaseConection connectNow = new DatabaseConection();
        Connection connectDB = connectNow.getConection();

        UsuarioDAO dao = new MYSQLUsuarioDAO(connectDB);
        String data = userName.getText();

        try{
            Usuario user = dao.obtener(data);
            if (userName.getText().equals(user.getUserName()) && password.getText().equals(user.getPassword())) {
                infoLabel.setText("Ingresó correctamente");
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("prueba.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 520, 380);
                stage.setTitle("prueba");
                stage.setScene(scene);
                stage.show();
            } else {
                infoLabel.setText("Datos incorrectos");
            }

        }catch (DAOException e){
            infoLabel.setText("Datos incorrectos");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
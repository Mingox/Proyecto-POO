package com.cenfotec.entregable1.view;

import com.cenfotec.entregable1.DatabaseConection;
import com.cenfotec.entregable1.dao.DAOException;
import com.cenfotec.entregable1.dao.UsuarioDAO;
import com.cenfotec.entregable1.dao.mysql.MYSQLUsuarioDAO;
import com.cenfotec.entregable1.modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
            } else {
                infoLabel.setText("Datos incorrectos");
            }

        }catch (DAOException e){
            infoLabel.setText("Datos incorrectos");

        }





    }


}
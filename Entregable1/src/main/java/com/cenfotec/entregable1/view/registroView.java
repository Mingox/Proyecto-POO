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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import static java.lang.Integer.parseInt;

public class registroView {

    @FXML
    private TextField newUsername;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField newNombre;
    @FXML
    private TextField newApellido;
    @FXML
    private TextField newEdad;
    @FXML
    private TextField newCorreo;
    @FXML
    private Button buscarArchivo;
    @FXML
    private Label mostrarRuta;
    @FXML
    private Label infoRegistro;
    @FXML
    private Button returnLoginButton;

    public String buttonBuscarArchivos(ActionEvent e){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        mostrarRuta.setText(String.valueOf(file));
        return String.valueOf(file);


    }

    public void regresarPantallaLogin() throws IOException {
        Stage stage = (Stage) returnLoginButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 380);
        stage.setTitle("Login");
        stage.setScene(scene);
        scene.getWindow().setWidth(520);
        scene.getWindow().setHeight(380);
        stage.show();
    }

    public void registroButonAction(ActionEvent a) throws DAOException {
        DatabaseConection connectNow = new DatabaseConection();
        Connection connectDB = connectNow.getConection();

        UsuarioDAO dao = new MYSQLUsuarioDAO(connectDB);
        if (!newUsername.getText().isBlank() && !newPassword.getText().isBlank() && !newNombre.getText().isBlank()
            && !newApellido.getText().isBlank() && !newEdad.getText().isBlank() && !newCorreo.getText().isBlank() && !mostrarRuta.equals("Foto Obligatoria")){

            try {
                String username = newUsername.getText();
                String password = newPassword.getText();
                String nombre = newNombre.getText();
                String apellido = newApellido.getText();
                int edad = Integer.parseInt(newEdad.getText());
                String correo = newCorreo.getText();
                String imagen = mostrarRuta.getText();
                Usuario user = new Usuario(username, password, "pendiente", nombre,apellido,edad,correo,imagen);
                dao.insertar(user);
                infoRegistro.setText("Registro exitoso!!");

            }catch (DAOException e){
                infoRegistro.setText("Datos incorrectos");
            }
        }else {
            infoRegistro.setText("Todos los campos son obligatorios");
        }

    }


}

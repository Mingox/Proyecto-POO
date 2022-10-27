package com.cenfotec.entregable1.controllers;

import com.cenfotec.entregable1.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class registroController extends Application {
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("registro.fxml"));
        Scene registro = new Scene(fxmlLoader.load(), 570, 350);
        stage.setTitle("Registro");
        stage.setScene(registro);
        stage.show();
    }
}

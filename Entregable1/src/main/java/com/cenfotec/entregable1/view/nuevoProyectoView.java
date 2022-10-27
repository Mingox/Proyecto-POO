package com.cenfotec.entregable1.view;

import com.cenfotec.entregable1.dao.DAOException;
import com.cenfotec.entregable1.dao.ProyectoDao;
import com.cenfotec.entregable1.dao.UsuarioDAO;
import com.cenfotec.entregable1.dao.mysql.DatabaseConection;
import com.cenfotec.entregable1.dao.mysql.MYSQLProyectoDAO;
import com.cenfotec.entregable1.dao.mysql.MYSQLUsuarioDAO;
import com.cenfotec.entregable1.modelos.Proyecto;
import com.cenfotec.entregable1.modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.time.format.DateTimeFormatter;

public class nuevoProyectoView {

    @FXML
    private TextField inputNombre;

    @FXML
    private TextField inputCategoria;
    @FXML
    private TextField inputRepositorio;

    @FXML
    private DatePicker inputFechaCreacion;

    @FXML
    private DatePicker inputUltimaModificacion;

    @FXML
    private Label infoRegistroProyecto;


    public void crearProyecto(ActionEvent a){
        DatabaseConection connectNow = new DatabaseConection();
        Connection connectDB = connectNow.getConection();

        ProyectoDao dao = new MYSQLProyectoDAO(connectDB);
        if (!inputNombre.getText().isBlank() && !inputCategoria.getText().isBlank()
                && !inputFechaCreacion.toString().isBlank() && !inputUltimaModificacion.toString().isBlank()){
            try {
                String nombre = inputNombre.getText();
                String categoria = inputCategoria.getText();
                String fechaCreacion = inputFechaCreacion.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String ultimaModificacion = inputUltimaModificacion.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String repositorio = inputRepositorio.getText();
                Proyecto proyecto = new Proyecto(nombre, categoria, fechaCreacion, ultimaModificacion, repositorio);
                dao.insertar(proyecto);
                File folderProyecto = new File("C:\\Users\\dflaq\\OneDrive\\Escritorio\\Proyecto-POO\\Entregable1\\src\\main\\java\\com\\cenfotec\\entregable1\\proyectos\\"+nombre);
                folderProyecto.mkdir();
                File folderInvestigacion = new File("C:\\Users\\dflaq\\OneDrive\\Escritorio\\Proyecto-POO\\Entregable1\\src\\main\\java\\com\\cenfotec\\entregable1\\proyectos\\"+nombre+"/Investigacion");
                folderInvestigacion.mkdir();
                File folderMedia = new File("C:\\Users\\dflaq\\OneDrive\\Escritorio\\Proyecto-POO\\Entregable1\\src\\main\\java\\com\\cenfotec\\entregable1\\proyectos\\"+nombre+"/Media");
                folderMedia.mkdir();

                infoRegistroProyecto.setText("Registro exitoso!!");

            }catch (DAOException e){
                infoRegistroProyecto.setText("Datos incorrectos");
            }
        }else {
            infoRegistroProyecto.setText("Todos los campos son obligatorios");
        }

    }

}

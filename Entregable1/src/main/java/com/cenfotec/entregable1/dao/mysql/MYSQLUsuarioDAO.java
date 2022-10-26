package com.cenfotec.entregable1.dao.mysql;

import com.cenfotec.entregable1.dao.DAO;
import com.cenfotec.entregable1.dao.DAOException;
import com.cenfotec.entregable1.dao.UsuarioDAO;
import com.cenfotec.entregable1.modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MYSQLUsuarioDAO implements UsuarioDAO {

    final String INSERT = "INSERT INTO usuarios(username, password, rol, nombre, apellido, edad, correo, imagen)" +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    final String GETONE = "SELECT * from usuarios WHERE username = ?";

    final String GETALL = "SELECT * from usuarios";
    private Connection connection;

    public  MYSQLUsuarioDAO(Connection conn){

        this.connection = conn;
    }

    @Override
    public void insertar(Usuario a) throws DAOException{

        PreparedStatement stat = null;
        try{
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, a.getUserName());
            stat.setString(2, a.getPassword());
            stat.setString(3, a.getRol());
            stat.setString(4, a.getNombre());
            stat.setString(5, a.getApellido());
            stat.setInt(6, a.getEdad());
            stat.setString(7, a.getCorreo());
            stat.setString(8, a.getImagen());
            if (stat.executeUpdate() == 0){
                throw new DAOException("No se insertó");
            }
        }catch (SQLException e){
            throw new DAOException("Error sql", e);
        } finally {
            if (stat != null){
                try {
                    stat.close();
                }catch (SQLException e){
                    throw new DAOException("Error sql", e);
                }
            }

        }
    }

    @Override
    public void modificar(Usuario a) {

    }

    @Override
    public void eliminar(Usuario a) {

    }

    private  Usuario convertir(ResultSet rs) throws SQLException{
        String username = rs.getString("username");
        String password = rs.getString("password");
        String rol = rs.getString("rol");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        int edad = rs.getInt("edad");
        String correo = rs.getString("correo");
        String imagen = rs.getString("imagen");
        Usuario usuario = new Usuario(username, password, rol, nombre, apellido, edad, correo, imagen);
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodos() throws  DAOException{
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try{
            stat = connection.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                usuarios.add(convertir(rs));
            }
        }catch (SQLException e){
            throw new DAOException("Error SQL", e);
        }finally {
            if (rs != null){
                try {
                    rs.close();
                }catch (SQLException e){
                    throw new DAOException("Error SQL", e);
                }
            }
            if (stat != null){
                try {
                    stat.close();
                }catch (SQLException e){
                    throw new DAOException("Error SQL", e);
                }
            }
        }
        return usuarios;
    }

    @Override
    public Usuario obtener(String id) throws DAOException{
        PreparedStatement stat = null;
        ResultSet rs = null;
        Usuario user = null;
        try{
            stat = connection.prepareStatement(GETONE);
            stat.setString(1, id);
            rs = stat.executeQuery();
            if (rs.next()){
                user = convertir(rs);
            }else {
                throw new DAOException("No se ha encontrado al usuario");
            }
        }catch (SQLException e){
            throw new DAOException("Error SQL", e);
        }finally {
            if (rs != null){
                try {
                    rs.close();
                }catch (SQLException e){
                    throw new DAOException("Error SQL", e);
                }
            }
            if (stat != null){
                try {
                    stat.close();
                }catch (SQLException e){
                    throw new DAOException("Error SQL", e);
                }
            }
        }
        return user;
    }
}

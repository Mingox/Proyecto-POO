package com.cenfotec.entregable1.dao.mysql;

import com.cenfotec.entregable1.dao.DAOException;
import com.cenfotec.entregable1.dao.ProyectoDao;
import com.cenfotec.entregable1.modelos.Proyecto;
import com.cenfotec.entregable1.modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MYSQLProyectoDAO implements ProyectoDao {

    final String INSERT = "INSERT INTO proyectos(nombre, categoria, fechaCreacion, ultimaModificacion, repositorio)" +
            "VALUES(?, ?, ?, ?, ?)";
    final String GETONE = "SELECT * from proyectos WHERE nombre = ?";

    final String GETALL = "SELECT * from proyectos";

    private Connection connection;

    public  MYSQLProyectoDAO(Connection conn){

        this.connection = conn;
    }
    @Override
    public void insertar(Proyecto a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = connection.prepareStatement(INSERT);
            stat.setString(1, a.getNombre());
            stat.setString(2, a.getCategoria());
            stat.setString(3, a.getFechaCreacion());
            stat.setString(4, a.getUltimaModificacion());
            stat.setString(5, a.getRepositorio());

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
    public void modificar(Proyecto a) throws DAOException {

    }

    @Override
    public void eliminar(Proyecto a) throws DAOException {

    }

    private  Proyecto convertir(ResultSet rs) throws SQLException{
        String nombre = rs.getString("nombre");
        String categoria = rs.getString("categoria");
        String fechaCreacion = rs.getString("fechaCreacion");
        String ultimaModificacion = rs.getString("ultimaModificacion");
        String repositorio = rs.getString("repositorio");
        Proyecto proyecto = new Proyecto(nombre, categoria, fechaCreacion, ultimaModificacion, repositorio);
        return proyecto;
    }

    @Override
    public List<Proyecto> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Proyecto> proyectos = new ArrayList<>();
        try{
            stat = connection.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                proyectos.add(convertir(rs));
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
        return proyectos;
    }

    @Override
    public Proyecto obtener(String nombre) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Proyecto proyecto = null;
        try{
            stat = connection.prepareStatement(GETONE);
            stat.setString(1, nombre);
            rs = stat.executeQuery();
            if (rs.next()){
                proyecto = convertir(rs);
            }else {
                throw new DAOException("No se ha encontrado al proyecto");
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
        return proyecto;
    }

}

package com.cenfotec.entregable1.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<Class, Data> {
    void insertar(Class a) throws DAOException;

    void modificar(Class a) throws DAOException;

    void eliminar(Class a) throws DAOException;

    List<Class> obtenerTodos() throws DAOException;

    Class obtener(Data id) throws DAOException;

}

package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface CrudDAO <T> {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean exist(String id) throws SQLException, ClassNotFoundException;

    void delete(String id) throws SQLException, ClassNotFoundException;

    ResultSet generateNextId() throws SQLException, ClassNotFoundException;

    T search(String id) throws SQLException, ClassNotFoundException;

    ArrayList<T> loadAll() throws SQLException, ClassNotFoundException;

}
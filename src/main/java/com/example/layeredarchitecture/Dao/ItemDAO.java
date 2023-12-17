package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    boolean saveItem (ItemDTO dto) throws SQLException, ClassNotFoundException;
    void updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;
    boolean existItem(String code) throws SQLException, ClassNotFoundException ;
    void deleteItem(String code) throws SQLException, ClassNotFoundException ;
    ResultSet generateNextId() throws SQLException, ClassNotFoundException ;
}
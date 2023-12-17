package com.example.layeredarchitecture.Dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    //private String code;
@Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> allItem = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
            allItem.add(itemDTO);
        }
        return allItem;
    }
@Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code,description,unitPrice,qtyOnhand) VALUES (?,?,?,?)");
        pstm.setString(1, dto.getCode());
        pstm.setString(2, dto.getDescription());
        pstm.setBigDecimal(3, dto.getUnitPrice());
        pstm.setInt(4, dto.getQtyOnHand());
        return pstm.executeUpdate() > 0;
    }
@Override
    public void updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET name=?, address=? WHERE id=?");
        pstm.setString(1, dto.getCode());
        pstm.setString(2, dto.getDescription());
        pstm.setBigDecimal(3, dto.getUnitPrice());
        pstm.setInt(4,dto.getQtyOnHand());
        pstm.executeUpdate() ;
    }
    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeQuery().next();
    }

    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM item WHERE code=?");
        pstm.setString(1, code);
        pstm.executeUpdate();

    }

    @Override
    public ResultSet generateNextId() throws SQLException,ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code LIMIT 1;");

        return rst;

    }
}



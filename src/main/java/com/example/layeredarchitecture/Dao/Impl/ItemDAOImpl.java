package com.example.layeredarchitecture.Dao.Impl;

import com.example.layeredarchitecture.Dao.SQLutil;
import com.example.layeredarchitecture.Dao.Custom.ItemDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/
        ResultSet rst = SQLutil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> allItem = new ArrayList<>();

        while (rst.next()){
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));
            allItem.add(itemDTO);

        }
        return allItem;
    }

    @Override
    public boolean save (ItemDTO dto) throws SQLException, ClassNotFoundException {

        return SQLutil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()) ;

    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {

        return SQLutil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }
    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1,code);*/
        ResultSet rst = SQLutil.execute("SELECT code FROM Item WHERE code=?",code);
        return rst.next();
    }
    @Override
    public void delete(String code) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);
        pstm.executeUpdate();*/
        SQLutil.execute("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public ResultSet generateNextId() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        return rst;
    }
    @Override
    public ItemDTO search(String newItemcode) throws SQLException,ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, newItemcode + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        return new ItemDTO(
                rst.getString(1),
                rst.getString(2),
                rst.getBigDecimal(4),
                rst.getInt(3)
        );*/
        ResultSet rst = SQLutil.execute("SELECT * FROM Item WHERE code=?",newItemcode);
        rst.next();
        return new ItemDTO(newItemcode +"",rst.getString("description"),rst.getBigDecimal("UnitPrice"),rst.getInt("qtyOnHand"));
    }
    @Override
    public ArrayList<ItemDTO> loadAll()throws SQLException,ClassNotFoundException{
     /*   Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/
        ResultSet rst = SQLutil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> allItemCodes = new ArrayList<>();

        while (rst.next()){
            allItemCodes.add(new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4)
            ));
        }
        return allItemCodes;
    }

}

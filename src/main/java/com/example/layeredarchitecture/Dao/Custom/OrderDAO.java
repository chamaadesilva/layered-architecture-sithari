package com.example.layeredarchitecture.Dao.Custom;

import com.example.layeredarchitecture.Dao.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    ResultSet generateNewOrderId() throws SQLException,ClassNotFoundException;

    void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;

    boolean saveOrder(String orderId, LocalDate date, String customerId) throws SQLException, ClassNotFoundException;
}
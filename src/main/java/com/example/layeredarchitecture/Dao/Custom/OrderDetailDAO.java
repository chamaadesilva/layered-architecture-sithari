package com.example.layeredarchitecture.Dao.Custom;

import com.example.layeredarchitecture.Dao.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailDAO extends CrudDAO<OrderDetailDTO> {

    boolean saveOrderDetail(String orderId , OrderDetailDTO dto) throws SQLException,ClassNotFoundException;
}
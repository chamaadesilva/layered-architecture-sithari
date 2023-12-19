package com.example.layeredarchitecture.Dao.Custom;

import com.example.layeredarchitecture.Dao.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {
  /*   ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

     boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

     void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

     boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

     void deleteCustomer(String id) throws SQLException, ClassNotFoundException;

     ResultSet generateNextId() throws SQLException, ClassNotFoundException;

     CustomerDTO searchCustomer(String id) throws SQLException,ClassNotFoundException;

     ArrayList<CustomerDTO> loadAllCustomerIds() throws SQLException,ClassNotFoundException;*/
}
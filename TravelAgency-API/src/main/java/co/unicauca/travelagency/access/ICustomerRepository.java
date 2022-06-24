/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.travelagency.access;

import co.unicauca.travelagency.domain.entity.Customer;
import java.util.List;

/**
 *
 * @author William
 */
public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(Integer id);
    boolean create(Customer newCustomer);
    boolean update(Customer newCustomer);
    boolean delete(Integer id);
}

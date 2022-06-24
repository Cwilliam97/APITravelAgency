/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.travelagency.domain.service;

/**
 *
 * @author William
 */
import co.unicauca.travelagency.access.ICustomerRepository;
import co.unicauca.travelagency.domain.entity.Customer;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

public class CustomerService {

    @Inject
    @Default
    ICustomerRepository repo;

    public CustomerService() {
    }

    public List<Customer> findAll() {
        return repo.findAll();
    }

    public Customer findById(int id) {
        return repo.findById(id);
    }

    public boolean create(Customer cust) {
        return repo.create(cust);
    }
    
    public boolean update(Customer cust) {
        return repo.update(cust);
    }

    public boolean delete(int id) {
        return repo.delete(id);
    }
    
}

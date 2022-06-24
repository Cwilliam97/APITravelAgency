/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.travelagency.access;

import co.unicauca.travelagency.domain.entity.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
public class CustomerRepositoryImplArrays implements ICustomerRepository{
    
    public static List<Customer> customers;

    public CustomerRepositoryImplArrays() {
        if (customers == null) {
            customers = new ArrayList<>();
            initialize();
        }
    }

    private void initialize() {
        customers.add(new Customer(1, "Andrea", "Sanchez", "Calle 14 No 11-12 Popayan", "3145878752", "andrea@hotmail.com", "Femenino"));
        customers.add(new Customer(2, "Libardo", "Pantoja", "Santa Barbar Popayan", "3141257845", "libardo@gmail.com", "Masculino"));
        customers.add(new Customer(3, "Carlos", "Pantoja", "Santa Barbar Popayan", "3141257846", "carlos@gmail.com", "Masculino"));
        customers.add(new Customer(4, "Fernanda", "Arevalo", "Calle 16 No 12-12 Popayan", "3154562133", "fercha@hotmail.com", "Femenino"));
        customers.add(new Customer(5, "Manuel", "Perez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(6, "Alejandro", "Mosquera", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(7, "Cesar", "Gutierres Sanchez", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(8, "Julio", "Bravo Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(9, "Alberto", "Mendez Bravo", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
        customers.add(new Customer(10, "Alexander", "Ponce Yepes", "Calle 12 No 12-12 Popayan", "3154575845", "fer@hotmail.com", "Masculino"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(Integer id) {
        for (Customer cust : customers) {
            if (cust.getId() == id) {
                return cust;
            }
        }
        return null;
    }
    

    @Override
    public boolean create(Customer newProduct) {
        Customer prod = this.findById(newProduct.getId());
        if (prod != null) {
            //Ya existe
            return false;
        }
        customers.add(newProduct);
        return true;
    }
    
    @Override
    public boolean update(Customer customer) {
        Customer cust = this.findById(customer.getId());
        if (cust != null) {
            cust.setFirstName(customer.getFirstName());//recordar modificar nombre
            cust.setLastName(customer.getLastName());//Recordar hacer la modificacion del apellido
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        int i = 0;
        for (Customer cust : customers) {
            if (cust.getId() == id) {
                customers.remove(i++);
                return true;
            }
        }
        return false;
    }
    
}

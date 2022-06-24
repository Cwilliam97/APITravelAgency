/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.travelagency.presentation.rest;

import co.unicauca.travelagency.domain.entity.Customer;
import co.unicauca.travelagency.domain.service.CustomerService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author William
 */
@Stateless
@Path("customers")
public class CustomerController {
    
    /**
     * Se inyecta la única implementación que hay de CustomerService
     */
    @Inject
    private CustomerService service;

    public CustomerController() {
    }

       /*
 Su uso desde consola mediante client url:
 curl -X GET http://localhost:8080/TravelAgency-API/travelagency-service/customers/
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customer> findAll() {
        return service.findAll();
    }
    
    
        /*
 Su uso desde consola mediante client url:
 curl -X GET http://localhost:8080/TravelAgency-API/travelagency-service/customers/1
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Customer findById(@PathParam("id") int id) {
        return service.findById(id);
    }
    
 /*
    Su uso desde consola mediante client url:
    curl -X POST http://localhost:8080/TravelAgency-API-REST/travelagency-service/customers/
        -H 'Content-Type: application/json' \
        -d '{
                "id":1,
                "firstName":"William",
                "lastName":"Caicedo",
                "address": "Carrera 1",
                "mobile": "12345678",
                "email": "wcaicedom@gmail.com",
                "gender":"Masculino"
        }'
    */
    
    @POST
     @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public String create(Customer cust) {
         if (service.create(cust)) {
             return "{\"ok\":\"true\", \"mensaje\":\"Cliente creado\",\"errores\":\"\"}";
         } else {
             return "{\"ok\":\"false\", \"mensaje\":\"No se pudo crear el Cliente\",\"errores\":\"Id ya existe\"}";
         }
     }

     /*
 Su uso desde consola mediante client url:
 curl -X PUT http://localhost:8080/TravelAgency-API-REST/travelagency-service/customers/

     \
 -H 'Content-Type: application/json' \
 -d d '{
                "id":1,
                "firstName":"William",
                "lastName":"Caicedo",
                "address": "Carrera 1",
                "mobile": "12345678",
                "email": "wcaicedom@gmail.com",
                "gender":"Masculino"
        }'
 */
 @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String update(Customer cust) {
        if (service.update(cust)) {
            return "{\"ok\":\"true\",\"mensaje\":\"Cliente modificado\",\"errores\":\"\"}";
 } else {
 return "{\"ok\":\"false\",\"mensaje\":\"No se pudo modificar el cliente\",\"errores\":\"Id no existe\"}";
 }
 }
    
 /*
 Su uso desde consola mediante client url:
 curl -X DELETE http://localhost:8080/TravelAgency-API-REST/travelagency-service/customers/1
 */
 @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") int id) {
        if (service.delete(id)) {
            return "{\"ok\":\"true\",\"mensaje\":\"Cliente borrado\",\"errores\":\"\"}";
 } else {
 return "{\"ok\":\"false\",\"mensaje\":\"No se pudo borrar el cliente\",\"errores\":\"Id no existe\"}";
 }
 }
    
}

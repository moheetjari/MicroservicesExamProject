/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examemployee.service;

import com.mycompany.examemployee.entity.Employeetb;
import com.mycompany.examemployee.model.EmployeeModel;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("employee")
public class EmployeeResource {

    @Inject
    EmployeeModel employeeModel;

    @GET
    @Path("data")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Employeetb> getAllEmployee() {
        
        
        try{
            System.out.println(employeeModel.getEmployeetbs());
            return employeeModel.getEmployeetbs();
        }catch( Exception e){
        }
//        System.out.println(employeeModel.getEmployeetbs());
//        return employeeModel.getEmployeetbs();

        return null;
    }
}

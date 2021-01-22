package com.mycompany.examemployee.service;

import com.mycompany.examemployee.entity.Employeetb;
import com.mycompany.examemployee.model.EmployeeModel;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/example")
public class ExampleService {
    
    @Inject
    EmployeeModel employeeModel;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Employeetb> getAllEmployee() {
        return employeeModel.getEmployeetbs();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addemployee/{departmentid}/{name}")
    public void addEmployee(@PathParam("departmentid") int departmentid, @PathParam("name") String name) {
        employeeModel.AddEmployee(departmentid, name);
    }
    
}

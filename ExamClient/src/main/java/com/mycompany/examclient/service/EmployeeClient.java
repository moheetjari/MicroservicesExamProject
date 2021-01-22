/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examclient.service;

import entity.Employeetb;
import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author admin
 */
@RegisterRestClient(baseUri = "http://localhost:8081/ExamEmployee/rest/example")
public interface EmployeeClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Employeetb> getAllEmployee();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addemployee/{departmentid}/{name}")
    public void addEmployee(@PathParam("departmentid") int departmentid, @PathParam("name") String name);
}

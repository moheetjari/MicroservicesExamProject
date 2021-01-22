/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examemployee.model;

import com.mycompany.examemployee.entity.Departmenttb;
import com.mycompany.examemployee.entity.Employeetb;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
public class EmployeeModel {

    EntityManager em;

    public EmployeeModel() {
        em = Persistence.createEntityManagerFactory("MyPU").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Employeetb> getEmployeetbs() {
        return em.createNamedQuery("Employeetb.findAll").getResultList();
    }

    public void AddEmployee(int DeptId, String Name) {
        Employeetb emp = new Employeetb();
        Departmenttb dept = new Departmenttb();
        dept.setId(DeptId);
        emp.setDepartmentId(dept);
        emp.setName(Name);
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examclient.servlets;

import com.mycompany.examclient.service.EmployeeClient;
import entity.Employeetb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 *
 * @author admin
 */
public class TestServlet extends HttpServlet {
    
    @RestClient
    @Inject
    EmployeeClient employeeClient;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (request.getParameter("txtname") != null) {
                String name = request.getParameter("txtname");
                int deptId = Integer.parseInt(request.getParameter("txtdept"));
                employeeClient.addEmployee(deptId, name);
                response.sendRedirect("TestServlet");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("<form method='post'>");
            out.println("<label>Department</label>");
            out.println("<br/>");
            out.println("<input type='number' name='txtdept' />");
            out.println("<br/>");
            out.println("<label>Name</label>");
            out.println("<br/>");
            out.println("<input type='text' name='txtname' />");
            out.println("<br/>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
            out.println("<table border='1'>");
            out.println("<tr><td>Id</td>");
            out.println("<td>Department Name</td>");
            out.println("<td>Name</td>");
            
            Collection<Employeetb> employeeList = employeeClient.getAllEmployee();
            
            for (Employeetb emp : employeeList) {
                out.println("<tr><td>" + emp.getId() + "</td>");
                out.println("<td>" + emp.getDepartmentId().getName() + "</td>");
                out.println("<td>" + emp.getName() + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

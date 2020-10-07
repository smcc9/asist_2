package com.emergentes.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.emergentes.modelo.persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SELVA
 */
@WebServlet(urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

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
            
            HttpSession ses = request.getSession();
        ArrayList<persona> lista = (ArrayList<persona>) ses.getAttribute("listaest");
        
        persona obj1 = new persona();
        int id, pos;
        int opcion = Integer.parseInt(request.getParameter("op"));
        
        switch (opcion){
            case 1:
                request.setAttribute("miPersona", obj1);
                request.getRequestDispatcher("editarr.jsp").forward(request, response);
                break;
            case 2:
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request, id);
                obj1 = lista.get(pos);
                request.setAttribute("miPersona", obj1);
                request.getRequestDispatcher("editarr.jsp").forward(request, response);
                break;
            case 3:
                pos= buscarIndice(request, Integer.parseInt(request.getParameter("id")));
                lista.remove(pos);
                ses.setAttribute("listaest", lista);
                response.sendRedirect("persona.jsp");
                break;
            case 4: 
                String nuevo = request.getParameter("nuevo");
                id= Integer.parseInt(request.getParameter("id"));
                int edad = Integer.parseInt(request.getParameter("edad"));
                
                obj1.setId(id);
                obj1.setNombre(request.getParameter("nombre"));
                obj1.setApellidos(request.getParameter("apellidos"));
                obj1.setEdad(edad);
                if (nuevo.equals("true")) {
                    lista.add(obj1);
                }else{
                    pos = buscarIndice(request, id);
                    lista.set(pos, obj1);                    
                }
                ses.setAttribute("listest", lista);
                response.sendRedirect("persona.jsp");
                break;
            default:
                response.sendRedirect("persona.jsp");
        }
    }
            
}

    private int buscarIndice(HttpServletRequest request, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
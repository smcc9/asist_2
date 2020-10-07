package com.emergentes.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.emergentes.modelo.libro;
import com.emergentes.modelo.libroDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/principal"})
public class principal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet principal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet principal at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession ses = request.getSession();
        libroDAO gestor = (libroDAO) ses.getAttribute("gestor");
        
        if(gestor == null){
            libroDAO auxi= new libroDAO();
            ses.setAttribute("gestor", auxi);
        }
        
        String op = request.getParameter("op");
        if(op ==null){
            op = "";
        }
        if(op.trim().equals("")){
            response.sendRedirect("visual/listado.jsp");
        }
        if(op.trim().equals("nuevo")){
            libro obj =new libro();
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/nuevo.jsp").forward(request, response);
        }
        if(op.trim().equals("editar")){
            int pos = gestor.posicion(Integer.parseInt(request.getParameter("id")));
            libro obj = gestor.getlibros().get(pos);
            
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/editar.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession ses =request.getSession();
        
        libroDAO gestor= (libroDAO) ses.getAttribute("gestor");
        libro obj =new libro();
        
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setAutor(request.getParameter("autor"));
        obj.setTitulo(request.getParameter("titulo"));
        obj.setEstado(Integer.parseInt(request.getParameter("estado")));
        
        String tipo = request.getParameter("tipo");
        
        if(tipo.equals("-1")){
            gestor.insertar(obj);
        }
        else{
            gestor.modificar(obj.getId(), obj);
        }
        response.sendRedirect("vista/listado.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

<%-- 
    Document   : persona
    Created on : 06-10-2020, 09:26:29 PM
    Author     : SELVA
--%>
<%@page import = "com.emergentes.modelo.Persona" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC persona</title>
    </head>
    <body>
        <%
        if (session.getAttribute("listaest")== null) {
                ArrayList<Persona> listaux = new ArrayList<Persona>();
                session.setAttribute("listaest", listaux);
            }
            ArrayList<Persona> lista = (ArrayList<Persona>) session.getAttribute("listaest");
        %>
        <h1>Lista de personas</h1>
        <a href="Controlador?op=1">Nuevo</a>
        <table>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Edad</th>
                <th></th>
                <th></th>
            </tr>
                <%
                if (lista != null) {
                    for (Persona item : lista) {
                %>
            <tr>
                <td><%= item.getId() %></td>   
                <td><%= item.getNombre() %></td>   
                <td><%= item.getApellidos() %></td>   
                <td><%= item.getEdad() %></td>   
                <td><a href="Controlador?op=2&id=<%= item.getId() %>">Modificar</a></td>   
                <td><a href="Controlador?op=3&id=<%= item.getId() %>" 
                       onclick='return confirm("Esta seguro de eliminar el registro ?");' >Eliminar</a></td>   
            </tr>
            <%
                    }
                }
            %>
            
        </table>
    </body>
</html>

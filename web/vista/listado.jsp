<%-- 
    Document   : listado
    Created on : 06-10-2020, 10:29:53 PM
    Author     : SELVA
--%>
<%@page import="com.emergentes.modelo.libroDAO" %>
<%@page import="com.emergentes.modelo.libro" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            libroDAO lista = (libroDAO) session.getAttribute("gestor");
        %>
        <h1>listado</h1>
        <p><a href="../principal?op=nuevo">Nuevo</a> </p>
        <%
            if (lista.getlibros().size()>0) {
        %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Estado</th>
                <th></th>
                <th></th>
            </tr>
        <%
            for (libro item : lista.getlibros()){
        %>
        <tr>
            <td><%= item.getId() %></td>
            <td><%= item.getTitulo() %></td>
            <td><%= item.getAutor() %></td>
            <td><%= item.getEstado() %></td>
            <td><a href="../principal?op=editar&id=<%=item.getId() %>">Editar</a></td>
            <td><a href="../principal?op=eliminar&id=<%=item.getId() %>">Eliminar</a></td>
        </tr>
        <%
        }
        %>
        </table>
        <%
        }
            else{
                out.println("<p>no existen registros");;
            }
        %>
    </body>
</html>

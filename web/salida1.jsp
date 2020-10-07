<%-- 
    Document   : salida1
    Created on : 06-10-2020, 09:30:07 PM
    Author     : SELVA
--%>
<%@page import="com.emergentes.modelo.rectangulo" %>
<%
    rectangulo miobj = (rectangulo) request.getAttribute("miobj");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Area del rectangulo</h1>
        <p>El area del rectangulo es: <%= miobj.getArea() %></p>        
        <a href="rectangulo.jsp">Volver</a>
    </body>
</html>

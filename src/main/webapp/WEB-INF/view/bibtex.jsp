<%-- 
    Document   : bibtex
    Created on : 17-Apr-2013, 23:07:22
    Author     : eolaine
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BibTex-generaattori</title>
    </head>
    
    <body>
        <c:forEach var="tex" items="${texes}">
        <li>${tex}
        </c:forEach>
    </body>

</html>

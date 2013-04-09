<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>
        <strong>Chat</strong><br />

        <p>Tervetuloa ${tunnus}!</p>
        
        <form method="POST">
            <input type="text" name="viesti" /><input type="submit" value="Lähetä" />
        </form>
        
        <ul>
            <c:forEach var="viesti" items="${viestit}">
                <li>${viesti}</li>
            </c:forEach>
        </ul>
        
        <a href="/Spring-chat/logout">kirjaudu ulos</a>
    </body>
</html>

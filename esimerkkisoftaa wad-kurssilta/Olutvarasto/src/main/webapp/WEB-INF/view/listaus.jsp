<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beer Wagon</title>
    </head>
    <body>
        <h1>Tervetuloa Beer Wagoniin!</h1>
        <h2>Oluemme:</h2>
        <c:forEach var="olut" items="${oluet}">
                <li>${olut.name}</li>
        </c:forEach>
        <form action="${pageContext.request.contextPath}/olut" method="POST">
            Olut: <input type="text" name="name"><br/>
            Id: <input type="text" name="id"><br/>
            <input type="submit" name="olut"><br/>        
        </form>
        
    </body>
</html>

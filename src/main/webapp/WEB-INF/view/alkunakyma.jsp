<%-- 
    Document   : Nakyma
    Created on : 09-Apr-2013, 19:35:25
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
        <h2>Järjestelmässä olevat viitteet</h2>

        <c:forEach var="reference" items="${references}">
            <li>${reference}<br/><br/>
        </c:forEach>

        <a href="bibtex">BibTex-linkki</a> - <a href="bibfile">Bibtex fileenä</a>

        <h2>Lisää uusi artikkeliviite</h2>

        <form action="${pageContext.request.contextPath}/lisaaviite" method="POST">
            Lyhenne/Abbreviation: <input type="text" name="abbreviation" size="5" value=""><br/>
            Kirjoittaja/Author: <input type="text" name="author" size="50" value=""><br/>
            Artikkeli/Title: <input type="text" name="title" size="50" value=""><br/>
            <!--            Kirja/Book title: <input type="text" name="bookTitle value=""><br/>-->
            Julkaisu/Journal: <input type="text" name="journal" size="50" value=""><br/>
            Vuosikerta/Volume: <input type="text" name="volume" size="5" value="0"><br/>
            Numero/Number: <input type="text" name="number" size="5" value="0"><br/>
            Vuosi/Year: <input type="text" name="year" size="5" value="0"><br/>           
            Sivut/Pages: <input type="text" name="pages" size="10" value=""><br/>
            Julkaisija/Publisher: <input type="text" name="publisher" size="24" value=""><br/>
            Osoite/Address: <input type="text" name="address" size="24" value=""><br/><br/>
            <input type="submit" value="Lisää" name="viite"><br/>        
        </form>
    </body>

</html>

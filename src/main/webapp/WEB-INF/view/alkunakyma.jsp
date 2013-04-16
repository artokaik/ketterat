<%-- 
    Document   : Nakyma
    Created on : 09-Apr-2013, 19:35:25
    Author     : eolaine
--%>

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
                <li>Kirjoittaja/Author: ${reference.author}</li>
                <li>Artikkeli/Title: ${reference.title}</li>
                <li>Julkaisu/Journal: ${reference.journal}</li>
                <li>Vuosikerta/Volume: ${reference.volume}</li>
                <li>Numero/Number: ${reference.number}</li>
                <li>Vuosi/Year: ${reference.year}</li>
                <li>Sivut/Pages: ${reference.pages}</li>
                <li>Julkaisija/Publisher: ${reference.publisher}</li>
                <li>Osoite/Address: ${reference.address}</li>
                <br>
                <br>
        </c:forEach>
        
        <h2>Lisää uusi artikkeliviite</h2>
        
        <form action="${pageContext.request.contextPath}/alkunakyma" method="POST">
            Kirjoittaja/Author: <input type="text" name="author" value=""><br/>
            Artikkeli/Title: <input type="text" name="title" value=""><br/>
<!--            Kirja/Book title: <input type="text" name="bookTitle value=""><br/>-->
            Julkaisu/Journal: <input type="text" name="journal" value=""><br/>
            Vuosikerta/Volume: <input type="text" name="volume" value="0"><br/>
            Numero/Number: <input type="text" name="number" value="0"><br/>
            Vuosi/Year: <input type="text" name="year" value="0"><br/>           
            Sivut/Pages: <input type="text" name="pages" value=""><br/>
            Julkaisija/Publisher: <input type="text" name="publisher" value=""><br/>
            Osoite/Address: <input type="text" name="address" value=""><br/>
            <input type="submit" value="Lisää" name="viite"><br/>        

        </form>
    </body>
</html>

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
        <h1>Lisää uusi artikkeliviite</h1>
        
        <form action="${pageContext.request.contextPath}/viitelisatty" method="POST">
            Kirjoittaja/Author: <input type="text" name="author"><br/>
            Artikkeli/Title: <input type="text" name="title"><br/>
            Julkaisu/Journal: <input type="text" name="journal"><br/>
            Nide/Volume: <input type="text" name="volume"><br/>
            Numero/Number: <input type="text" name="number"><br/>
            Vuosi/Year: <input type="text" name="year"><br/>           
            Sivut/Pages: <input type="text" name="pages"><br/>
            Julkaisija/Publisher: <input type="text" name="publisher"><br/>
            Osoite/Address: <input type="text" name="year"><br/>
            <input type="submit" name="viite"><br/>        
        </form>
    </body>
</html>

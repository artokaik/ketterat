<%-- 
    Document   : Nakyma
    Created on : 09-Apr-2013, 19:35:25
    Author     : eolaine
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
            <form action="${pageContext.request.contextPath}/poistaviite" method="DELETE">
                <li>${reference}<br/>
                    <input type="submit" value="Poista"><br/>
            </form>

        </c:forEach> 


        <br>
        <br>
        <a href="bibfile.tex">BibTex-linkki</a>

        <h2>Lisää uusi viite</h2>



        <form action="${pageContext.request.contextPath}/lisaaviite" method="POST">
            Viitetyyppi: <select name="reftype">
                <option value="article">Artikkeli/Article</option>
                <option value="inproceedings">Inproceedings</option>
                <option value="book">Kirja/Book</option>
            </select><br/>
            Kirjoittaja/Author: <input type="text" name="author" size="50" value=""><br/>
            Toimittaja/Editor: <input type="text" name="editor" size="50" value=""><br/>
            Nimi/Title: <input type="text" name="title" size="50" value=""><br/>
            Pöytäkirja/Book title: <input type="text" name="booktitle" size="50" value=""><br/>
            Organisaatio/Organization: <input type="text" name="organization" size="50" value=""><br/>
            Julkaisu/Journal: <input type="text" name="journal" size="50" value=""><br/>
            Vuosikerta/Volume: <input type="text" name="volume" size="5" value="0"><br/>
            Numero/Number: <input type="text" name="number" size="5" value="0"><br/>
            Vuosi/Year: <input type="text" name="year" size="5" value="0"><br/>  
            Kuukausi/Month: <input type="text" name="month" size="9" value=""><br/>
            Sivut/Pages: <input type="text" name="pages" size="10" value=""><br/>
            Julkaisija/Publisher: <input type="text" name="publisher" size="24" value=""><br/>
            Osoite/Address: <input type="text" name="address" size="24" value=""><br/><br/>
            <input type="submit" value="Lisää" name="viite"><br/>        
        </form>


    </body>

</html>

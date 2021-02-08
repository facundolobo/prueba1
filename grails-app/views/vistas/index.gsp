
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>
    </head>
    <body>
        <h1>Lista de los datos contenidos en domain "Primer dominio"</h1>
        <g:each in="${lista}" var="item"> 
            <li>la ${item?.frutas} sabe "${item?.sabores}"</li>
        </g:each>
    </body>
</html>

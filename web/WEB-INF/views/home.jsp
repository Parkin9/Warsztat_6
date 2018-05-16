<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 27.04.18
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Controller</title>
</head>
<body>

    <p>
        <h1>Strona główna</h1>
        <c:out value="Witaj ${helloUsername}!" default="Witaj!"/>
        <hr>
    </p>

    <ul>
        <li><a href="/user/registration">Rejestracja</a></li>
        <li><a href="/user/login">Logowanie</a></li>
        <li><a href="/tweet/create">Tweet</a></li>
        <li><a href="/tweet/create">Pokaż wszystkie Tweety</a></li>
        <hr>
        <li><a href="/user/logout">Wyloguj</a></li>
    </ul>

</body>
</html>

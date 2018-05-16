<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 28.04.18
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>

    <p>
        <a href="/">Strona główna</a>
    </p>
    <hr>
    <%--@elvariable id="login" type="pl.coderslab.model.Login"--%>
    <form:form modelAttribute="login">
        <form:errors path="*"/>

        <label for="username">Nazwa użytkownika: </label>
        <form:input path="username" id="username"/><br>

        <label for="password">Hasło: </label>
        <form:password path="password" id="password"/><br>

        <button type="submit">Zaloguj</button>

    </form:form>

</body>
</html>

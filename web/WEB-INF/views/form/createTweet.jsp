<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 01.05.18
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweetuj</title>
</head>
<body>

    <p>
        <a href="/">Strona główna</a>
    </p>
    <hr>
    <%--@elvariable id="tweet" type="pl.coderslab.model.Tweet"--%>
    <form:form modelAttribute="tweet">
        <form:errors path="*"/>

        <label for="text">Co słuchać? </label><br>
        <form:textarea path="text" id="text"/><br>

        <button type="submit">Tweet</button>

    </form:form>

</body>
</html>

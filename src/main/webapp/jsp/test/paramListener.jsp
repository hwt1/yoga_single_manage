<%--
  Created by IntelliJ IDEA.
  User: wenting.huang
  Date: 2023/4/13
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("hello","world");
    request.setAttribute("hello","w1234");
    request.removeAttribute("hello");

    session.setAttribute("hello","world");
    session.setAttribute("hello","w1234");
    session.removeAttribute("hello");

    application.setAttribute("hello","world");
    application.setAttribute("hello","w1234");
    application.removeAttribute("hello");
%>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: wenting.huang
  Date: 2023/4/6
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login test</title>
</head>
<body>
<form action="/index/login" method="post">
用户名：<input type="text" name="username"><br>
密码：<input type="password" name="password"><br>
    <input type="submit" value="提交">
    <a href="/myServlet2">myServlet2</a>
</form>

</body>
</html>

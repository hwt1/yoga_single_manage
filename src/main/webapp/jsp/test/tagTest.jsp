<%--
  Created by IntelliJ IDEA.
  User: wenting.huang
  Date: 2023/4/13
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
EL表达式：${name}<br>
request方式：
<%=request.getAttribute("name")%>
<form action="/index/toTagShow" method="get">
    用户名：<input name="uname">
    <input type="submit" value="提交">
</form>
</body>
</html>

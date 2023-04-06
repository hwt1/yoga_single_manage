<%--
  Created by IntelliJ IDEA.
  User: wenting.huang
  Date: 2023/4/6
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>用户名：<%=request.getParameter("username")%></p>
<p>密码：<%=request.getParameter("password")%></p>
<p> JSessionId: <%= session.getId()%> </p>
<p> 从session中获取userId: <%= session.getAttribute("myUseId")%> </p>

</body>
</html>

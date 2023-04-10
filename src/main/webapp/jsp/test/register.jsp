<%--
  Created by IntelliJ IDEA.
  User: wenting.huang
  Date: 2023/4/10
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<%--
action表示提交的位置，可以提交给controller中的方法，
也可以提交给自定义的servlet，提交给servlet其实也就是提交给另一个jsp页面
 --%>
<form action="/registerServlet" method="post" enctype="multipart/form-data">
    <p>用户名：<input name="uname"></p>
    <p>密码：<input name="pwd"></p>
    <p>头像：<input type="file" name="pic"></p>
    <p><input type="submit" name="注册"/></p>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: wenting.huang
  Date: 2023/4/14
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <h3>演示JSTL标签库</h3>
    EL:uname:${uname}<br>  <%-- 等价于 <% request.getAttributer('uname') %>  注意不是 request.getParameter('uname') 的值 --%>
   <%-- request.getParameter: <% request.getParameter("uname");%>--%>
    <!-- 可看见的注释内容 -->
    <c:if test="${uname == '123'}">
        用户名正确
    </c:if><br/>
    <c:choose>
        <c:when test="${uname == '111'}">
            欢迎，${uname}
        </c:when>
        <c:when test="${uname == '222'}">
            ${uname}，该去写作业了
        </c:when>
        <c:otherwise>
            ${uname} 很高兴认识你！
        </c:otherwise>
    </c:choose><br/>

    爱好：
    <c:forEach items="${hobbies}" var="h" varStatus="sts">
        ${h}-current:${sts.current}-index:${sts.index}-count:${sts.count}
        -first:${sts.first}-last:${sts.last}-begin:${sts.begin}-end:${sts.end}-step:${sts.step}<br>   <%--varStatus:javax.servlet.jsp.jstl.core.LoopTagSupport--%>
        <%--
        current：当前这次迭代的（集合中的）项。
        index：当前这次迭代从0开始的迭代索引。
        count：当前这次迭代从1开始的迭代计数。
        first：用来表明当前这轮迭代是否为第一次迭代，该属性为boolean类型。
        last：用来表明当前这轮迭代是否为最后一次迭代，该属性为boolean类型。
        begin：begin属性的值。
        end：end属性的值
        step：step属性的值--%>
    </c:forEach>
</head>
<body>

</body>
</html>

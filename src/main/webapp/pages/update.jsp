<%--
  Created by IntelliJ IDEA.
  User: 17270
  Date: 2019/8/7
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<sf:form action="${pageContext.request.contextPath}/update" method="post" modelAttribute="account" >
    <sf:hidden path="id"/>
<table border="1">
    <tr>
        <td>username</td>
        <td><sf:input path="username"/></td>
    </tr>
    <tr>
        <td>balance</td>
        <td><sf:input path="balance"/></td>
    </tr>
    <tr>
        <td><input type="submit" value="修改"></td>
    </tr>
</table>
</sf:form>--%>
<form action="${pageContext.request.contextPath}/update" method="post" >
    <input type="hidden" name="id" value="${account.id}"/>
<table border="1">
    <tr>
        <td>username</td>
        <td><input name="username" type="text" value="${account.username}"/></td>
    </tr>
    <tr>
        <td>balance</td>
        <td><input name="balance" type="text" value="${account.balance}"/></td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center"><input type="submit" value="修改"></td>
    </tr>
</table>
</form>
</body>
</html>

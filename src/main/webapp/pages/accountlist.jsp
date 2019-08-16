<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17270
  Date: 2019/8/7
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function btn(str) {
        if (str==1){
            var form=document.getElementById("form1");
            form.action="${pageContext.request.contextPath}/batchDelete";
            form.submit();
        }else if (str==2){
            var form=document.getElementById("form1");
            form.action="${pageContext.request.contextPath}/batchUpdate";
            form.submit();
        }
    }
</script>
<body>
<form action="${pageContext.request.contextPath}/getById" method="post">
通过ID搜索:<input type="text" name="id"><span style="color: red">${msg}</span>
</form>
<form action="${pageContext.request.contextPath}/batchDelete" method="post"  id="form1">
<table border="1" style="text-align: center">
    <tr>
        <td>#</td>
        <td>username</td>
        <td>balance</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${accountList}" varStatus="s" var="account">
        <tr>
            <td><input type="checkbox" name="accountList[${s.index}].id" value="${account.id}"/></td>
            <td><input type="text" name="accountList[${s.index}].username" value="${account.username}"/></td>
            <td><input type="text" name="accountList[${s.index}].balance" value="${account.balance}" /></td>
            <td>
                <a href="${pageContext.request.contextPath}/edit?id=${account.id}">修改</a>
                <a href="${pageContext.request.contextPath}/delete?id=${account.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
    <input type="button" value="批量删除" onclick="btn(1)">
    <input type="button" value="批量修改" onclick="btn(2)">
</form>
</body>
</html>

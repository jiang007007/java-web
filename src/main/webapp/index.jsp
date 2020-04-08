<%@ page import="java.util.concurrent.CopyOnWriteArraySet" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>向session设置一个属性</title>
    </head>
<body>
    <%
        CopyOnWriteArraySet
        session.setAttribute("name","aaa");
        System.out.println("向session设置了一个属性");
    %>
<h2>Hello World!</h2>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>用户名:</td>--%>
            <%--<td>--%>
                <%--<input type="text" name="username" value="${formbean.username}">${form.username}--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
</body>
</html>

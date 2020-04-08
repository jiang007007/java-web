<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.concurrent.CopyOnWriteArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/3 0003
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
      CopyOnWriteArrayList
    String value= session.getAttribute("name");
    out.write(value);
  %>
</body>
</html>

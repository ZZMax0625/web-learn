<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h2>登陆页面</h2>
<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("user","zhangsan");
%>
<h3>
    <%=request.getAttribute("msg")%>
</h3>
</body>
</html>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h2>hello webFilter</h2>
<h3>
    <%
        HttpSession session1 = request.getSession();
     %>
</h3>
<h3>
    <%=session1.getAttribute("user")%>
</h3>
</body>
</html>
<%@ page import="java.util.List" %>
<%@ page import="com.zzmax.exercise.enerty.User" %>
<%@ page import="com.zzmax.exercise.enerty.Brand" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>品牌主页</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css">
    <link rel="stylesheet" href="css/me.css">
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user");
    List<Brand> brands = (List<Brand>) request.getAttribute("brands");
%>
<h1><%=user.getUsername()%>,欢迎您</h1>

<div class="container">
    <div id="table-container">
        <table th:fragment="blogList" class="ui compact teal table">
            <thead>
            <tr>
                <th>序号</th>
                <th>品牌名称</th>
                <th>企业名称</th>
                <th>排序</th>
                <th>品牌介绍</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Brand brand : brands) {
            %>
            <tr>
                <td><%=brand.getId()%>
                </td>
                <td><%=brand.getBrandName()%>
                </td>
                <td><%=brand.getCompanyName()%>
                </td>
                <td><%=brand.getOrdered()%>
                </td>
                <td><%=brand.getDescription()%>
                </td>
                <td>
                    <%
                        if (brand.getStatus() == 0) {
                    %>
                    禁用
                    <%
                    } else {
                    %>
                    启用
                    <%
                        }
                    %>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/selectById?id=<%=brand.getId()%>" class="ui basic mini teal button">编辑</a>
                    <a href="${pageContext.request.contextPath}/deleteBrand?id=<%=brand.getId()%>" class="ui basic mini red button">删除</a>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
            <tfoot>
            <tr>
                <th colspan="7">
<%--                    <a href="#" class="ui mini right floated teal basic button">新增</a>--%>
                    <input class="ui mini right floated teal basic button" type="button" value="新增" id="add">
                </th>
            </tr>
            </tfoot>
        </table>
    </div>
</div>


<script>
    document.getElementById("add").onclick = function () {
        location.href = "addBrand.jsp";
    }
</script>
</body>
</html>
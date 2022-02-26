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
<h2><a href="hello-servlet?type=html">返回html</a></h2>
<h2><a href="hello-servlet?type=img">返回图片</a></h2>
<h2><a href="hello-servlet?type=json">返回json</a></h2>

<h2><a href="responseDemo01">/responseDemo01</a></h2>
<h2><a href="regist.html">验证码页面</a></h2>
<h2><a href="download.html">下载的页面</a></h2>
<h2></h2>
</body>
</html>
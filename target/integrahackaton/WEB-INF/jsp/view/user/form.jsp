<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vitor
  Date: 02/02/19
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="produto" type="java"--%>
<%--@elvariable id="user" type="java"--%>
<form:form action="${s:mvcUrl('UC#grava').build()}" method="POST" enctype="multipart/form-data" modelAttribute="user">
    <div>
        <label>Titulo</label>
        <form:input path="titulo"/>
    </div>

    <button type="submit">Cadastrar</button>
</form:form>
</body>
</html>

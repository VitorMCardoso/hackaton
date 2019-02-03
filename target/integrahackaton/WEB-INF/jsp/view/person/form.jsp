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
<%--@elvariable id="person" type="java"--%>
<form:form action="${s:mvcUrl('PC#grava').build()}" method="POST" enctype="multipart/form-data" modelAttribute="person">
    <div>
        <label>Nome</label>
        <form:input path="nome"/>
    </div>
    <div>
        <label>Documento</label>
        <form:input path="documento"/>
    </div>

    <button type="submit">Cadastrar</button>
</form:form>
</body>
</html>

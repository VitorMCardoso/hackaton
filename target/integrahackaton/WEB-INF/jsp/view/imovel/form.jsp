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
<%--@elvariable id="imovel" type=""--%>
<form:form action="${s:mvcUrl('IC#grava').build()}" method="POST" enctype="multipart/form-data" modelAttribute="imovel">
    <div>
        <label>Logradouro</label>
        <form:input path="logradouro"/>
    </div>
    <div>
        <label>Bairro</label>
        <form:input path="bairro"/>
    </div>
    <div>
        <form:select path="atividade">
            <form:option value="RESIDENCIA">RESIDENCIA</form:option>
            <form:option value="COMERCIO">COMERCIO</form:option>
            <form:option value="DESMANCHE">DESMANCHE</form:option>
            <form:option value="HOSPITAL">HOSPITAL</form:option>
        </form:select>
    </div>

    <button type="submit">Cadastrar</button>
</form:form>
</body>
</html>

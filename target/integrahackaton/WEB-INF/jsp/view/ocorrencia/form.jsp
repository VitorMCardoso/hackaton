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
<%--@elvariable id="ocorrencia" type="java"--%>
<form:form action="${s:mvcUrl('OC#grava').build()}" method="POST" enctype="multipart/form-data" modelAttribute="ocorrencia">
    <div>
        <label>Duf</label>
        <form:input path="duf"/>
    </div>
    <div>
        <label>Data Duf</label>
        <form:input path="dataDuf"/>
    </div>
    <div>
        <label>Data Entrega</label>
        <form:input path="dataEntrega"/>
    </div>
    <div>
        <label>Fiscal</label>
        <form:input path="fiscal"/>
    </div>
    <div>
        <label>Observacao</label>
        <form:input path="observacao"/>
    </div>
    <div>
        <label>Prazo Dias</label>
        <form:input path="prazoDias"/>
    </div>
    <div>
        <label>Ouvidoria</label>
        <form:input path="ouvidoria"/>
    </div>
    <div>
        <label>Prazo Vencimento</label>
        <form:input path="vencimentoPrazo"/>
    </div>
    <div>
        <form:select path="tipo">
            <form:option value="NOTIFICACAO">NOTIFICACAO</form:option>
            <form:option value="AUTUACAO">AUTUACAO</form:option>
            <form:option value="TERMO">TERMO</form:option>
        </form:select>
    </div>

    <div>
        <label>Person</label>
        <form:input path="personName"/>
    </div>

    <div>
        <label>Imovel</label>
        <form:input path="imovelName"/>
    </div>

    <button type="submit">Cadastrar</button>
</form:form>
</body>
</html>

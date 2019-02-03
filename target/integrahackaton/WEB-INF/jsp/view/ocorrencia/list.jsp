<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>Lista de produtos</h1>

<div>${sucesso}</div>

<table>
    <tr>
        <td>Titulo</td>
    </tr>

    <c:forEach items="${ocorrencia}" var="ocorrencia">
        <tr>
            <td>${ocorrencia.duf}</td>
        </tr>
        <tr>
            <td>${ocorrencia.observacao}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
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
<h1>Person</h1>

<div>${sucesso}</div>

<table>

    <c:forEach items="${imovel}" var="imovel">
        <tr>
            <td>${imovel.logradouro}</td>
        </tr>
        <tr>
            <td>${imovel.bairro}</td>
        </tr>
        <tr>
            <td>${imovel.atividade}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
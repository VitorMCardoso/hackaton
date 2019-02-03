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
<h1>User</h1>

<div>${sucesso}</div>

<table>
    <tr>
        <td>Titulo</td>
    </tr>

        <tr>
            <td>${user.titulo}</td>
        </tr>

</table>
</body>
</html>
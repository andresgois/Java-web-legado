<%@ page import="java.util.List, br.com.gerenciador.servlet.model.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url  value="/alteraEmpresa" var="linkNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Editar dados</h2>
	<form action="${linkNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome" value="${empresa.nome }" /> <br />
		Data abertura: <input type="text" name="data" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />" /> <br />
		<input type="hidden" name="id" value="${empresa.id }" />
		<input type="submit" value="Enviar" />
	</form>
	
</body>
</html>
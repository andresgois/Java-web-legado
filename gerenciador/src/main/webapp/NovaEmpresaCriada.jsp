<%
    /*String novaEmpresa = (String) request.getAttribute("nomeEmpresa");
    System.out.println("Empresa = "+novaEmpresa);*/
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url  value="/listaEmpresas" var="listaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>

<%-- <h3>Cadastrando nova empresa:  <%=  novaEmpresa %> </h3> --%>
<c:if test="${not empty nomeEmpresa }">
	<h3>Expressiona language</h3>
	<p>
		Nome de empresa pela expressão: ${ nomeEmpresa }
	</p>
	<a href="${listaEmpresa }">
	Lista de Empresas
	</a>
</c:if>

<c:if test="${empty nomeEmpresa }">
	<h3>Nenhuma Empresa encontrada</h3>
</c:if>

</body>
</html>
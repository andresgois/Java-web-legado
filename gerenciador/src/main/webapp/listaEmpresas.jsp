<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% /* @ page import="java.util.List, br.com.gerenciador.servlet.model.Empresa" */ %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
 <h3>Lista de Empresas - Novo</h3>
 
 <ul>
 	<c:forEach items="${ empresas }" var="empresa">
 		<li>
 			${ empresa.nome } | 
 			<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />
 		</li>
 	</c:forEach>
 </ul>
 
<%-- <%	List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas"); 
	for(Empresa emp: lista) {
%>
	<li> <%= emp.getNome() %></li>
<% }  %> --%>



</body>
</html>
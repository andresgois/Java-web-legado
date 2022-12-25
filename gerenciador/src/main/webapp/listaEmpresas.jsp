<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.gerenciador.servlet.model.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
<h3>Lista de Empresas</h3>
<%	List<Empresa> lista = (List<Empresa>) request.getAttribute("empresa"); 
	for(Empresa emp: lista) {
%>
	<li> <%= emp.getNome() %></li>
<% }  %>

</body>
</html>
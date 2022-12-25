<%
    String novaEmpresa = (String) request.getAttribute("nomeEmpresa");
    System.out.println("Empresa = "+novaEmpresa);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>

<h3>Cadastrando nova empresa:  <%=  novaEmpresa %> </h3>


</body>
</html>
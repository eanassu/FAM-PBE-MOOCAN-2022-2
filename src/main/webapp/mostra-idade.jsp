<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste de par�metros</title>
</head>
<body>
  Par�metro recebido:
  A idade � ${param.idade}
  
  <jsp:useBean id="funcionario" class="br.vemprafam.pojo.Funcionario"/>
  
  ${funcionario.nome}
</body>
</html>
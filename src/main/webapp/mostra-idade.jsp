<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste de parâmetros</title>
</head>
<body>
  Parâmetro recebido:
  A idade é ${param.idade}
  
  <jsp:useBean id="funcionario" class="br.vemprafam.pojo.Funcionario"/>
  
  ${funcionario.nome}
</body>
</html>
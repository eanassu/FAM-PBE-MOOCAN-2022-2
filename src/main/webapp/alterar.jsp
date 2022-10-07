<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.vemprafam.pojo.Funcionario"%>
<%@page import="br.vemprafam.dao.DaoFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração</title>
</head>
<body>
<%
DaoFuncionario dao = new DaoFuncionario();
int re = Integer.parseInt(request.getParameter("re"));
Funcionario f = dao.buscarPeloRe(re);
SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
String dataAdmStr = format.format(f.getDataAdmissao());
%>
<form action='gravarAlteracao'>
RE:<input type='text' name='re' value="<%=f.getRe()%>"/><br/>
nome:<input type='text' name='nome' value="<%=f.getNome()%>"/><br/>
data de admissão:<input type='text' name='dataAdm' value="<%=dataAdmStr%>"/><br/>
salário:<input type='text' name='salario' value="<%=f.getSalario()%>"/><br/>
e-mail:<input type='text' name='email' value='<%=f.getEmail()%>'/><br/>
<input type='submit' value='enviar'>
</form>
</body>
</html>
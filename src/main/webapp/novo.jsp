<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello World JSP<br/>
<%-- Coment�rio JSP --%>
<%
String texto = "Texto teste";

out.println(texto);
System.out.println("Executado!");
%>
<br/>
<%=texto %>
</body>
</html>
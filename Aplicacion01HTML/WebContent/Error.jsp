<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Ha ocurrido un error en la aplicación :<%=exception.getMessage() %><br />
	Error Interno: <%=exception.getCause().getMessage() %>
</body>
</html>
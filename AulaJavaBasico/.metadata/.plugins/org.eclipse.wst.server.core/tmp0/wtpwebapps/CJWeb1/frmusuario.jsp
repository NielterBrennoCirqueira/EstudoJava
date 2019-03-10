<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Cadastro de Usuario</title>
</head>
<body>

	
	<c:import url="includes/menu.jsp"></c:import>


	<form action="usucontroller.do" method="post">
			
		<label>ID: </label>
		<input type="text" readonly="readonly" name="txtid" value="${usuario.id}" size="20"/>
		
		<label>Nome: </label>
		<input type="text" name="txtnome" value="${usuario.nome}" size="20"/>
	
		<label>Login: </label>
		<input type="text" name="txtlogin" value="${usuario.usuario}" size="20"/>
		
		<label>Senha: </label>
		<input type="password" name="txtsenha" value="${usuario.senha}" size="20"/>
		
		<input type="submit" value="Salvar" /> 
	
	
		</form>

</body>
</html>
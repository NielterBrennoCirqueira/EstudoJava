<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista usuario</title>

<script type="text/javascript">

function confirmaExclusao(id){
	if(window.confirm("Tem Certeza que deseja excluir o Registro: "+id)){
		location.href="usucontroller.do?acao=exc&id="+id;
	}
	
	
}


</script>


</head>
<body>

<c:import url="includes/menu.jsp"></c:import>

<table border="2">
	<tr bgcolor="#CCCCCC">
		<th> ID </th> <th> Nome</th> <th> Login</th> <th> Senha</th> <th> Ação </th>
	</tr>

<c:forEach items="${requestScope.lista}" var = "usu">

	<tr>
		<td>${usu.id}</td>
		<td>${usu.nome}</td>
		<td>${usu.usuario}</td>
		<td>${usu.senha}</td>
		<td><a href="javascript:confirmaExclusao(${usu.id})"> Excluir </a></td>
		|
		<td><a href="usucontroller.do?acao=alt&id=${usu.id}"> Alterar </a></td>		
	</tr>
</c:forEach>


	</table>

</body>
</html>
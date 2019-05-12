<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Inicio</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="/path/to/jquery.min.js"></script>
    <script src="/path/to/bootstrap.min.js"></script>
    <script src="/path/to/bootstrap-hover-dropdown.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/styles2.css">
</head>

<body>
 <section id="Inicio">
 	<header id="headerInicio">   


 <div id="menu">
                    
        <ul>
             <li class="nivel1"><a href="#" class="nivel1">Cuenta</a>
                <ul class="nivel2">
                     <li><a href="inicio.jsp">Inicio</a></li>
                     <li><a href='PerfilController?usu=${usuario.usuario}'>Perfil</a></li>
                     <li><a href="seguidores.jsp">Seguidores</a></li>
                     <li><a href="siguiendo.jsp">Siguiendo</a></li>
                     <li><a href="#">Cerrar sesión</a></li>
                 </ul>
             </li>
        </ul>
                </div>

 <img id="logo" src="resources/fotos/logo.png" alt="">
 <h1 id="titulo" class="text-left">ShadiaGram</h1>

</header>

<section id="inicioFotos">
<c:forEach var="publi" items="${uDao.listaPublicaciones(usuario)}">

	<div>
	<img src="${publi.nombre}" alt="">
    <label>@ <c:out value="${publi.usuarioBean.usuario}"></c:out></label> </div>
    
    
</c:forEach>	
</section>

<aside id="sugerencias">





	<label id="sug" >Sugerencias</label>

<c:forEach var="usuarios" items="${uDao.list()}">

<div id="userSugerencia">
<label> ${usuarios.usuario} </label>
</div>
<form action="Perfil2control?usu2=${usuarios.usuario}" method="POST">
<input type="submit" id="botonSugerenciaUser" value="Ver"/>
</form>
           
</c:forEach>

	
</aside>


 </section>

	
</body>
<footer>
    
    <h2>Copyright: ShadiaGram 2019</h2>
</footer>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Siguiendo</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="/path/to/jquery.min.js"></script>
    <script src="/path/to/bootstrap.min.js"></script>
    <script src="/path/to/bootstrap-hover-dropdown.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/styles2.css">
    
</head>


<body>
    

   <section id="principal">
<header id="headerPerfil">
     <div id="datos" class="container">

     <img class="img" id="fotoPerfil" src="resources/fotos/robbins.jpg" alt="">         
     <h1 id="nombreusuario"><c:out value="${usuario.nombre} ${usuario.apellido}"></c:out></h1>
     <img  class="logo" src="resources/fotos/logo.png" alt="">    
     <h1  class="shadia">ShadiaGram</h1>
     
     <h3 id="user">@<c:out value="${usuario.usuario}"></c:out></h3>
     <h4>Seguidores :</h4><label for=""><c:out value="${uDao.cantidadSeguidores(usuario)}"></c:out></label>        
     

       </div>
 </header>    

<nav >
       
    
    <div id="menu" class="btn-group">
                    
        <ul>
             <li class="nivel1"><a href="#" class="nivel1">Cuenta</a>
                <ul class="nivel2">
                     <li><a href="inicio.jsp">Inicio</a></li>
                     <li><a href="Perfil.jsp">Perfil</a></li>
                     <li><a href="seguidores.jsp">Seguidores</a></li>
                     <li><a href="siguiendo.jsp">Siguiendo</a></li>
                     <li><a href="#">Cerrar sesión</a></li>
                 </ul>
             </li>
        </ul>

    </div>             
</nav>
   	


<section id="seccionFotos">
	

<div  class="row">
  <c:forEach var="seguidor" items="${usuario.amistads1}">

<div id="fotos" class="col-12 publicacion border border-primary">

<div class="row"> <h3>@<c:out value="${seguidor.usuario2.nombre}"></c:out></h3> </div>




     </div>             
</c:forEach>

</div>





</section>


   </section>


	
</body>


<%@ include file = "template/footer.jsp" %>
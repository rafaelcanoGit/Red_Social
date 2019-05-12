<%@ include file = "template/header.jsp" %>

<body>
 <div class="container" id="registration-form">
        <div class="image"></div>
        <div class="frm">

<div class="container">
            <h1>Registrarte</h1>
            <img id="logo2" src="resources/fotos/logo.png" alt="">
</div>
            <form action="controllerServlet" method="POST" >

            <div class="form-row mb-4">
                <div class="form-group">
                   
                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Name">
                </div>
                <div class="form-group">
                    
                    <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Last Name">
                </div>
            </div>
                <div class="form-group">
                    
                    <input type="text" class="form-control"  id="usuario" name="usuario" placeholder="Username">
                </div>
                <div class="form-group">
               
                    <input type="email" class="form-control"  id="email" name="email" placeholder="E-mail">
                </div>
                <div class="form-group">
                    
                    <input type="password" class="form-control"  id="password" name="password" placeholder="Password">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg">Submit</button>
                </div>
                <p class="text-right "  >Ya tienes cuenta <a href="ingresa.jsp" >Ingresa</a>
        </p>
            </form>
        </div>
    </div>

</body>


<%@ include file = "template/footer.jsp" %>
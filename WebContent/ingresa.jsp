<%@ include file = "template/header.jsp" %>

<body>
	
<div class="container" id="login">
        <div class="image"></div>
        <div class="frm">

           <div class="container">
           
            <h1 id="Ingresa">Ingresa</h1>
            <img id="logo2" src="resources/fotos/logo.png" alt="">
</div>
            <form action="controllerServlet2" method="POST" >
                
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" name="email" class="form-control" id="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" name="password" class="form-control" id="pwd" placeholder="Enter password">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg">Submit</button>
                </div>    
            </form>
        </div>
    </div>




</body>


<%@ include file = "template/footer.jsp" %>

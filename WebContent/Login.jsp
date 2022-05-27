<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head> 
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/poker.css">
</head>
<body>
<div class="container">
	<div class="row">
        <div class="col-md-12">
            <div class="well well-sm">
                <form class="form-horizontal" action="login" method="post">
                    <fieldset >
                        <legend class="text-center header bg-dark text-white">Ingresar</legend>
                         
                         <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                            <div class="col-md-12">
                                <input id="usuario" name="usuario" type="text" placeholder="Usuario" value="<c:out value='${usuario.user}' />" class="form-control">
                            </div>
                        </div>
                         
                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                            <div class="col-md-12">
                                <input id="pas" name="pas" type="text" placeholder="Contraseña" value="<c:out value='${usuario.pas}' />" class="form-control">
                            </div>
                        </div>
                        

                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-primary btn-lg">Ingresar</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
       
    </div>
</div>

</html>
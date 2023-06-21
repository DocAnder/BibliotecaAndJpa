<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    String msg = request.getParameter("msg");
    if(msg == null){
        msg = "";
    }

%>
<html lang="pt-br">
<head>
    <style>
        form {
            border: 3px solid #b893f7;
            margin-left: 35%;
            margin-right: 35%;
            margin-top: 20px;
            padding: 10px;
        }
        input{
            width: 400px;
        }
        button{
            width: 200px;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <title>Biblioteca Alexandria</title>
</head>
<body class="text-center">
<div class="center">
    <form action="login" method="post">

        <h1 class="h3 mb-3 fw-normal">Biblioteca Alexandria</h1>

        <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="user">
            <label for="floatingInput">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
            <label for="floatingPassword">Password</label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <span><%= msg %></span>

    </form>

</div>


</body>
</html>




<%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 21/05/2023
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

  Boolean logado = (Boolean) session.getAttribute("is_logged_in");
  if(logado == null || logado == false){
    response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/index.jsp");
  }

  String msg = request.getParameter("msg");
  if(msg == null){
    msg = "";
  }else{
    msg = "Preencha todos os campos!";
  }




%>


<html>
<head>
  <style>
    .container{
      margin-left: 30%;
      margin-right: 30%;
      padding: 20px;
    }
    h1{
      text-align: center;
    }
    .containerButton{
      width: 200px;
    }

    .usuarios{
      margin-left: 10%;
      margin-right: 10%;
      padding: 20px;
    }
  </style>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <title>Title</title>
</head>
<body>
<div class="container">
  <form action="CreatNewUserServlet" method="post">
    <h1 class="h3 mb-3 fw-normal">Cadastro de Novo Usuario</h1>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Novo usuario" name="userName">
      <label for="floatingInput">Nome</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput2" placeholder="Email" name="userEmail">
      <label for="floatingInput2">Email</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput3" placeholder="Tipo" name="userType">
      <label for="floatingInput3">Tipo(administrador ou regular)</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput4" placeholder="senha" name="userPassword">
      <label for="floatingInput4">Senha</label>
    </div>
    <div class="containerButton">
      <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
    </div>
    <p><b> <%= msg %> </b></p>
  </form>
</div>


</body>
</html>

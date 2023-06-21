<%@ page import="com.example.bibliotecaandjpa.domain.entities.Livro" %>
<%@ page import="com.example.bibliotecaandjpa.utils.DateFormater" %><%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 25/05/2023
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    Boolean logado = (Boolean) session.getAttribute("is_logged_in");
    if(logado == null || logado == false){
        response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/index.jsp");
    }


    Livro livro = (Livro) request.getAttribute("livro");

    String msg = (String) request.getAttribute("msg");
    if(msg == null){
        msg = "";
    }else{
        msg = "Necessário preencher todos os campos!";

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
    <form action="EditControllerServlet?codigo=<%= livro.getId() %>" method="post">
        <h1 class="h3 mb-3 fw-normal">Atualizar Livro</h1>
        <p>ID: <%= livro.getId() %></p>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" placeholder="<%= livro.getNome() %>" name="bookName" value="<%= livro.getNome() %>">
            <label for="floatingInput">Titulo</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput2" placeholder="<%= livro.getAutor().getNome() %>" name="autorName" value="<%= livro.getAutor().getNome() %>">
            <label for="floatingInput2">Nome do Autor</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput3" placeholder="<%= livro.getStatus() %>" name="status" value="<%= livro.getStatus() %>">
            <label for="floatingInput3">Status</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput4" placeholder="<%= DateFormater.dateParaString(livro.getDate()) %>" name="date" value="<%= DateFormater.dateParaString(livro.getDate()) %>" >
            <label for="floatingInput4">Data lançamento</label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
    </form>
    <p>NOTA: Caso o autor informado não esteja cadastrado, um novo será criado automaticamente.</p>
    <p><b> <%= msg %> </b></p>
</div>

</body>
</html>
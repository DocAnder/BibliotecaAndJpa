<%@ page import="com.example.bibliotecaandjpa.domain.entities.Livro" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.bibliotecaandjpa.domain.entities.User" %>
<%@ page import="com.example.bibliotecaandjpa.utils.DateFormater" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%

  Boolean logado = (Boolean) session.getAttribute("is_logged_in");
  if(logado == null || logado == false){
    response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/index.jsp");
  }

  ArrayList<Livro> livros = (ArrayList<Livro>) request.getAttribute("livros");

  User usuario = (User) session.getAttribute("user");

  String link;
  if(usuario.getType().equals("admin")){
    link = "<a href=\"createUser.jsp\" method=\"get\"> <button class=\"w-100 btn btn-sm btn-primary\" type=\"button\">Cadastrar Novo Usuario</button></a>";
  }else{
    link = "";
  }


  String msg = request.getParameter("msg");
  if(msg == null){
    msg = "";
  }else{
    msg = "<div class=\"alert alert-primary d-flex align-items-center\" role=\"alert\">\n" +
            "      <svg xmlns=\"http://www.w3.org/2000/svg\" class=\"bi bi-exclamation-triangle-fill flex-shrink-0 me-2\" viewBox=\"0 0 16 16\" role=\"img\" aria-label=\"Warning:\">\n" +
            "        <path d=\"M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z\"></path>\n" +
            "      </svg>\n" +
            "      <div>\n" +
            "        Só é possivel deletar um livro cujo status seja INDISPONÍVEL\n" +
            "      </div>\n" +
            "    </div>";
  }







%>
<html>
<head>
  <style>
    .caixa{
      margin-left: 30%;
      margin-right: 30%;
      padding: 20px;
      border-collapse: collapse; /* CSS2 */
      border: 1px solid black;

    }
    .bordas{
      border-bottom: 1px solid black;
      border-collapse: collapse; /* CSS2 */
      padding: 4px;
    }
    .center{
      text-align: center;
    }
    .w-100 btn btn-sm btn-primary{
      width: 100px;
    }
  </style>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
  <title>Title</title>
</head>
<body>
<h1 class="center">Lista de Livros</h1>
<p>Bem vindo <%=usuario.getName()%> !</p>

<div class="caixa">
  <div class="containerButton">
    <a href="creatBooks.jsp" method="get"> <button class="w-100 btn btn-sm btn-primary" type="button">Cadastrar Novo Livro</button></a>
  </div>
  <p></p>
  <div class="containerButton">
    <p> <%= link %> </p>
  </div>
  <p> <%= msg %> </p>
    <% for (int i = 0; i < livros.size(); i++) {%>
  <div>
    <a id=<%=i%> href="EditControllerServlet?codigo=<%= livros.get(i).getId() %>" method="get" class="list-group-item " aria-current="true" onmouseenter="entrou(id)" onmouseleave="saiu(id)">
      <div class="d-flex w-100 justify-content-between ">
        <h5 class="mb-1"><%= livros.get(i).getNome() %></h5>
        <span class="badge bg-primary rounded-pill align-items-center"> <%= livros.get(i).getId() %></span>
        <% request.setAttribute("codigo", 1); %>
      </div>
      <p class="mb-1"> Autor: <%= livros.get(i).getAutor().getNome() %> | Data de Criação: <%= DateFormater.dateParaString(livros.get(i).getDate()) %> </p>
      <small>Status: <%= livros.get(i).getStatus() %></small>
    </a>
    <div class="dropdown">
      <button class="btn btn-primary dropdown-toggle btn-sm" type="button" data-bs-toggle="dropdown" aria-expanded="false">
        Alterar Status
      </button>
      <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="EditStatusControllerServlet?status=Disponivel&id=<%= livros.get(i).getId() %>">Disponivel</a></li>
        <li><a class="dropdown-item" href="EditStatusControllerServlet?status=Indisponivel&id=<%= livros.get(i).getId() %>">Indisponivel</a></li>
        <li><a class="dropdown-item" href="EditStatusControllerServlet?status=Emprestado&id=<%= livros.get(i).getId() %>">Emprestado</a></li>
      </ul>
      <a class="btn btn-outline-warning btn-sm" href="DeleteBookControllerServlet?id=<%= livros.get(i).getId() %>&status=<%= livros.get(i).getStatus() %>" method="get" role="button">Delete</a>

      <p class="bordas"></p>

    </div>

    <%}%>
  </div>

  <script>


    function entrou(num){
      let a = document.getElementById(num);
      a.style.background = '#AFD6F8'
    }

    function saiu(num){
      let a = document.getElementById(num);
      a.style.background = 'white'
    }

  </script>




</body>
</html>

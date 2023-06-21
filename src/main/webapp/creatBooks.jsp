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
        msg = "Preencha todos os campos para cadastrar um novo livro!";

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
    <form action="CreatNewBookServlet" method="post">

        <h1 class="h3 mb-3 fw-normal">Cadastro de Livro</h1>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" placeholder="Livro Novo" name="bookName" value="">
            <label for="floatingInput">Titulo</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput2" placeholder="Autor" name="autorName">
            <label for="floatingInput2">Nome do Autor</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput3" placeholder="Indisponivel" name="status">
            <label for="floatingInput3">Status (Disponivel, Indisponivel, Emprestado)</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput4" name="floatingInput4" placeholder="01/01/2010" onblur="formatarData()" >
            <label for="floatingInput4">Data de lançamento (somente numeros)</label>
        </div>
        <div class="containerButton">
            <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
        </div>
        <p>NOTA: Caso o autor informado ainda não exista no sistema, um novo será cadastrado automaticamente.</p>
        <p><b> <%= msg %> </b></p>
    </form>

</div>

<script>

    function formatarData() {
        let inputData = document.getElementById("floatingInput4").value;
        let dataFormatada = inputData.slice(0, 2) + "/" + inputData.slice(2, 4) + "/" + inputData.slice(4);

        document.getElementById("floatingInput4").value = dataFormatada;
    }




</script>

</body>
</html>
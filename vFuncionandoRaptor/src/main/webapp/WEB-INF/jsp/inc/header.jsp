<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <title>Portifólio Pessoal</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="${linkTo[AuthController].login}">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${linkTo[DocumentoController].list}">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Documentos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${linkTo[DocumentoController].list}">Listagem de Documentos</a>
                            <a class="dropdown-item" href="${linkTo[DocumentoController].form}"><span class="badge badge-secondary">Novo</span> Documento</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Categorias
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${linkTo[CategoriaController].list}">Listagem de Categorias</a>
                            <a class="dropdown-item" href="${linkTo[CategoriaController].form}"><span class="badge badge-secondary">Nova</span> Categoria</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Tags
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${linkTo[TagController].list}">Listagem de Tags</a>
                            <a class="dropdown-item" href="${linkTo[TagController].form}"><span class="badge badge-secondary">Nova</span> Tag</a>
                        </div>
                    </li>
                    <c:if test="${loggedUser.usuario.administrator}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Usuarios
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${linkTo[UsuarioController].list}">Listagem de Usuarios</a>
                                <a class="dropdown-item" href="${linkTo[UsuarioController].form}"><span class="badge badge-secondary">Novo</span> Usuario</a>
                            </div>
                        </li>
                    </c:if>
                </ul>
                <form class="form-inline my-2 my-lg-0">                    
                    <c:if test="${loggedUser.logged}">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Bem Vindo: ${loggedUser.usuario.nome}</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-outline-danger" href="${linkTo[AuthController].logout}">LogOut</a>
                    </c:if>
                </form>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4 text-center">Meu Portfólio Pessoal.</h1>
                    <p class="lead text-center">Confira abaixo minhas principais publicações!</p>
                </div>
            </div>


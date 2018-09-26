<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${linkTo[DocumentController].list}">Home</a></li>        
        <li class="breadcrumb-item active" aria-current="page">Usuarios</li>
    </ol>
</nav>
<h1>Listagem de Usuarios!</h1>
<table class="table table-striped">
    <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Ações</th>
        </tr>
    </thead>
    <c:forEach items="${usuarioList}" var="usuario">
        <tr>
            <td>${usuario.id}</td>
            <td>${usuario.nome}</td>
            <td>
                <a class="btn btn-secondary" href="${linkTo[UsuarioController].update}${usuario.id}">Editar</a>
                <a class="btn btn-danger" href="${linkTo[UsuarioController].delete}${usuario.id}">Deletar</a>
            </td>
        </tr>   
    </c:forEach>
</table>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${linkTo[DocumentController].list}">Home</a></li>        
        <li class="breadcrumb-item"><a href="${linkTo[UsuarioController].list}">Usuarios</a></li>
        <li class="breadcrumb-item active" aria-current="page">Novo Usuario</li>
    </ol>
</nav>
<div class="col-md-6 offset-md-3">
    <h1>Keyword (Cadastro)</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
            </c:forEach>
        </c:if>

    <c:if test="${not empty usuario.id}">
        <form action="${linkTo[UsuarioController].atualiza}" method="POST">
            <input type="text" class="hidden" style="display: none; " name="usuario.id" value="${usuario.id}"/>
        </c:if>

        <c:if test="${empty usuario.id}">
            <form action="${linkTo[UsuarioController].save}" method="POST">
            </c:if>


            <div class="form-group">
                <label>Nome: </label>
                <input type="text" class="form-control" name="usuario.nome" value="${usuario.nome}"/>
            </div>
            <div class="form-group">
                <label>Usuario: </label>
                <input type="text" class="form-control" name="usuario.usuario" value="${usuario.usuario}"/>
            </div>
            <div class="form-group">
                <label>Senha: </label>
                <input type="text" class="form-control" name="usuario.senha" value="${usuario.senha}"/>
            </div>
            <div class="form-group">
                <label>Administrador: </label>
                <select name="usuario.administrator" class="form-control">
                    <option value="false">Não</option>
                    <option value="true">Sim</option>
                </select>
            </div>
            <div>
                <button type="submit" class="btn btn-primary" data-toggle="tooltip" data-placement="left" title="Salvar Alterações">Gravar</button>
            </div>
        </form>
</div>
<c:import url="/WEB-INF/jsp/inc/footer.jsp"/>

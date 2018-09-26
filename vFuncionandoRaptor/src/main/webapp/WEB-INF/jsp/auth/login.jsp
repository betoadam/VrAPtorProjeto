<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>
<div class="col-md-6 offset-md-3">
    <h1>Auth (login)!</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
            </c:forEach>
        </c:if> 
    <form action="${linkTo[AuthController].autenticar}" method="POST">
        <div class="form-group">
            <label>Usuario:</label>
            <input type="text" class="form-control" name="usuario.usuario"/>
        </div>
        <div class="form-group">
            <label>Senha:</label>
            <input type="password" class="form-control" name="usuario.senha"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary" data-toggle="tooltip" data-placement="left" title="Realizar Login">LogIn</button>
        </div>
    </form>


    <h1>Auth (Register)</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
            </c:forEach>
        </c:if>
    <form action="${linkTo[AuthController].registrar}" method="POST">
        <div class="form-group">
            <label>Nome:</label>
            <input type="text" class="form-control" name="usuario.nome"/>
        </div>
        <div class="form-group">
            <label>Usuario:</label>
            <input type="text" class="form-control" name="usuario.usuario"/>
        </div>
        <div class="form-group">
            <label>Senha:</label>
            <input type="password" class="form-control" name="usuario.senha"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary" data-toggle="tooltip" data-placement="left" title="Salvar Novo Usuario">registrar</button>
        </div>
    </form>
</div>
<c:import url="/WEB-INF/jsp/inc/footer.jsp"/>

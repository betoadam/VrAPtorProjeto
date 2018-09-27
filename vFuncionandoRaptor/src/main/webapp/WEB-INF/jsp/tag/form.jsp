<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${linkTo[DocumentoController].list}">Home</a></li>        
        <li class="breadcrumb-item"><a href="${linkTo[TagController].list}">Tags</a></li>
        <li class="breadcrumb-item active" aria-current="page">Nova Tag</li>
    </ol>
</nav>
<div class="col-md-6 offset-md-3">
    <h1>Tag (Cadastro)</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.categoria} ${err.message}</li>
            </c:forEach>
        </c:if>

    <c:if test="${not empty tag.name}">
        <form action="${linkTo[TagController].atualiza}" method="POST">
            <input type="text" class="hidden" style="display: none; " name="tag.id" value="${tag.id}"/>
        </c:if>

        <c:if test="${empty tag.name}">
            <form action="${linkTo[TagController].save}" method="POST">
            </c:if>


            <div class="form-group">
                <label>Tag: </label>
                <input type="text" class="form-control" name="tag.name" value="${tag.name}"/>
            </div>
            <div>
                <button type="submit" class="btn btn-primary" data-toggle="tooltip" data-placement="left" title="Salvar Alterações">Gravar</button>
            </div>
        </form>
</div>
<c:import url="/WEB-INF/jsp/inc/footer.jsp"/>

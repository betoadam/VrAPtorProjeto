<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${linkTo[DocumentController].list}">Home</a></li>        
        <li class="breadcrumb-item"><a href="${linkTo[KeywordController].list}">Keywords</a></li>
        <li class="breadcrumb-item active" aria-current="page">Nova Keyword</li>
    </ol>
</nav>
<div class="col-md-6 offset-md-3">
    <h1>Keyword (Cadastro)</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
            </c:forEach>
        </c:if>

    <c:if test="${not empty keyword.name}">
        <form action="${linkTo[KeywordController].atualiza}" method="POST">
            <input type="text" class="hidden" style="display: none; " name="keyword.id" value="${keyword.id}"/>
        </c:if>

        <c:if test="${empty keyword.name}">
            <form action="${linkTo[KeywordController].save}" method="POST">
            </c:if>


            <div class="form-group">
                <label>Keyword: </label>
                <input type="text" class="form-control" name="keyword.name" value="${keyword.name}"/>
            </div>
            <div>
                <button type="submit" class="btn btn-primary" data-toggle="tooltip" data-placement="left" title="Salvar Alterações">Gravar</button>
            </div>
        </form>
</div>
<c:import url="/WEB-INF/jsp/inc/footer.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${linkTo[DocumentoController].list}">Home</a></li>        
        <li class="breadcrumb-item active" aria-current="page">Tags</li>
    </ol>
</nav>
<h1>Listagem de Tags!</h1>
<table class="table table-striped">
    <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Tag</th>
            <th>Ações</th>
        </tr>
    </thead>
    <c:forEach items="${tagList}" var="tag">
        <tr>
            <td>${tag.id}</td>
            <td>${tag.name}</td>
            <td>
                <a class="btn btn-secondary" href="${linkTo[TagController].update}${tag.id}">Editar</a>
                <a class="btn btn-danger" href="${linkTo[TagController].delete}${tag.id}">Deletar</a>
            </td>
        </tr>   
    </c:forEach>
</table>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
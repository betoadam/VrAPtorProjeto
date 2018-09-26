<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${linkTo[DocumentController].list}">Home</a></li>        
        <li class="breadcrumb-item active" aria-current="page">Categorias</li>
    </ol>
</nav>
<h1>Listagem de Categorias!</h1>
<table class="table table-striped">
    <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Categoria</th>
            <th>Ações</th>
        </tr>
    </thead>
    <c:forEach items="${categoryList}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>
                <a class="btn btn-secondary" href="${linkTo[CategoryController].update}${category.id}">Editar</a>
                <a class="btn btn-danger" href="${linkTo[CategoryController].delete}${category.id}">Deletar</a>
            </td>
        </tr>   
    </c:forEach>
</table>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>
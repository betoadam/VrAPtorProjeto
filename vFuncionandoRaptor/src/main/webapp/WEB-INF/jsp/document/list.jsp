<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>

<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="${linkTo[DocumentController].list}">Home</a></li>        
    <li class="breadcrumb-item active" aria-current="page">Documentos</li>
  </ol>
</nav>

<h1>Listagem de Documentos!</h1>
<table class="table table-striped">
    <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Autor</th>
            <th>Descrição</th>
            <th>Nome do Arquivo</th>
            <th>Data</th>
            <th>Ultima Atualização</th>
            <th>Categoria</th>
            <th>Keywords</th>
            <th>Ações</th>
        </tr>
    </thead>
    <c:forEach items="${documentList}" var="document">
        <tr>
            <td>${document.id}</td>
            <td>${document.usuario.nome}</td>
            <td>${document.description}</td>
            <td>${document.fileName}</td>
            <td>${document.date}</td>
            <td>${document.lastUpdate}</td>
            <td>${document.category.name}</td>
            <td>    
                <c:forEach items="${document.keywords}" var="keyword">
                    <span>${keyword.name}</span>
                </c:forEach>
            </td>
            <td>
                <a class="btn btn-secondary" href="${linkTo[DocumentController].update}${document.id}">Editar</a>
                <a class="btn btn-danger" href="${linkTo[DocumentController].delete}${document.id}">Deletar</a>
            </td>
        </tr>   
    </c:forEach>
</table>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>

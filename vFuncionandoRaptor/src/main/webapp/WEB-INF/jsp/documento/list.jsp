<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>

<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="${linkTo[DocumentoController].list}">Home</a></li>        
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
            <th>Tags</th>
            <th>Ações</th>
        </tr>
    </thead>
    <c:forEach items="${documentoList}" var="documento">
        <tr>
            <td>${documento.id}</td>
            <td>${documento.usuario.nome}</td>
            <td>${documento.description}</td>
            <td>${documento.fileName}</td>
            <td>${documento.date}</td>
            <td>${documento.lastUpdate}</td>
            <td>${documento.categoria.name}</td>
            <td>    
                <c:forEach items="${documento.tags}" var="tag">
                    <span>${tag.name}</span>
                </c:forEach>
            </td>
            <td>
                <a class="btn btn-secondary" href="${linkTo[DocumentoController].update}${documento.id}">Editar</a>
                <a class="btn btn-danger" href="${linkTo[DocumentoController].delete}${documento.id}">Deletar</a>
            </td>
        </tr>   
    </c:forEach>
</table>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>

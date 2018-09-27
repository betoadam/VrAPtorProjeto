<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${linkTo[DocumentoController].list}">Home</a></li>        
        <li class="breadcrumb-item"><a href="${linkTo[DocumentoController].list}">Documentos</a></li>
        <li class="breadcrumb-item active" aria-current="page">Novo Documento</li>
    </ol>
</nav>
<div class="col-md-6 offset-md-3">
    <h1>Documento (Cadastro)</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.categoria} ${err.message}</li>
            </c:forEach>
        </c:if>

    <c:if test="${not empty documento.id}">
        <form action="${linkTo[DocumentoController].atualiza}" method="POST">
            <input type="text" class="hidden" style="display: none; " name="id" value="${documento.id}"/>
        </c:if>

        <c:if test="${empty documento.id}">
            <form action="${linkTo[DocumentoController].save}" method="POST">
            </c:if>


            <div class="form-group">
                <label>Descrição:</label>
                <input type="text" class="form-control" name="description" value="${documento.description}" required/>
            </div>
            <div class="form-group">
                <label>Nome do Arquivo:</label>
                <input type="text" class="form-control" name="fileName" value="${documento.fileName}" required/>
            </div>
            <div class="form-group">
                <label>Data:</label>
                <input type="date" class="form-control" name="date"/>
            </div>
            <div class="form-group">
                <label>Ultima Atualização:</label>
                <input type="date" class="form-control" name="lastUpdate"/>
            </div>
            <div class="form-group">
                <label>Categoria:</label>
                <select class="form-control" name="selectedCategoriaId" required>
                    <c:forEach items="${categorias}" var="categoria">
                        <option value="${categoria.id}">${categoria.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Tags:</label>
                <select class="form-control" name="tags[]" size="10" multiple required>
                    <c:forEach items="${tags}" var="tag">
                        <option value="${tag.id}">${tag.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <button type="submit" class="btn btn-primary" data-toggle="tooltip" data-placement="left" title="Salvar Alterações">Gravar</button>
            </div>
        </form>
</div>
<c:import url="/WEB-INF/jsp/inc/footer.jsp"/>

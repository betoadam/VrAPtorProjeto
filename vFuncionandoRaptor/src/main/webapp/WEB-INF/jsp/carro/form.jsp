<%-- 
    Document   : form
    Created on : Aug 30, 2018, 1:16:20 PM
    Author     : Leonardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>
<div class="col-md-6 offset-md-3">
    <h1>Carro (Cadastro)</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
            </c:forEach>
        </c:if>

    <form action="${linkTo[CarroController].save}" method="POST">
        <div class="form-group">
            <label>Marca:</label>
            <input type="text" class="form-control" name="carro.marca"/>
        </div>
        <div class="form-group">
            <label>Modelo:</label>
            <input type="text" class="form-control" name="carro.modelo"/>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Gravar</button>
        </div>
    </form>
</div>
<c:import url="/WEB-INF/jsp/inc/footer.jsp"/>

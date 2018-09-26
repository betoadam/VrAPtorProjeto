<%-- 
    Document   : list
    Created on : Aug 30, 2018, 1:24:12 PM
    Author     : Leonardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/jsp/inc/header.jsp"/>
<%-- <c:import url="/WEB-INF/jsp/inc/header.jsp"/>           INCLUSAO DE PAGINA VIA JSTL --%>
<%-- <jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>       INCLUSAO DE PAGINA VIA JSP --%> 

<h1>Listagem de Carros!</h1>
<table class="table table-striped">
    <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Ações</th>
        </tr>
    </thead>
    <c:forEach items="${carroList}" var="car">
        <tr>
            <td>${car.id}</td>
            <td>${car.marca}</td>
            <td>${car.modelo}</td>
            <td></td>
        </tr>   
    </c:forEach>
</table>
<h5>${mensagem}</h5>
<h5>${data}</h5>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>

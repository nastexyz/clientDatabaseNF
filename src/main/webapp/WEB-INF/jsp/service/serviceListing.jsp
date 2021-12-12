<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<strong> Lista pakietów </strong>

<c:forEach items="${service}" var="s">
    Nazwa Usługi:

    <strong>
        <c:out value="${s.serviceName}"/><br>
    </strong>

    Kategoria usługi:

    <c:out value="${s.serviceCategory}"/><br>


    <br />
    <a href="edit?idToEdit=${s.id}">
        Edytuj
    </a>
    </br />
    <a href="remove?idToRemove=${s.id}">
        Usuń
    </a>
    <p>

</c:forEach>

<br />
<a href="add">
    Dodaj nową usługę
</a>
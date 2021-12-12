<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<strong> Lista osób z obsługi </strong> <br />


<c:forEach items="${therapist}" var="t">

    Nazwisko:
    <c:out value="${t.therapistFirstName}"/><br>

    Imię:
    <c:out value="${t.therapistLastName}"/><br>

    Login:
    <c:out value="${t.login}"/><br>

    <br />
    <a href="edit?idToEdit=${t.id}">
        Edytuj
    </a>

    </br />
    <a href="remove?idToRemove=${t.id}">
        Usuń
    </a>
    <p>

</c:forEach>

<br />
<a href="/therapist/register">
    Dodaj nową osobę
</a>
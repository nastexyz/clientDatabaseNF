<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<strong> Lista klientek </strong> <br>

<c:forEach items="${person}" var="p">

<strong>
<c:out value="${p.firstName} ${p.lastName}"/><br>
</strong>
<c:out value="${p.address}"/> <br>
<c:out value="${p.postcode} ${p.city}"/><br>
Telefon: <c:out value="${p.phoneNumber}"/><br>
email: <c:out value="${p.email}"/><br>
Data pierwszej wizyty: <c:out value="${p.firstVisitDate}"/><br>

Korzysta z usługi:
<c:forEach items="${p.serviceName}" var="p1">
    <c:out value="${p1} "/>
</c:forEach><br>
Osoba prowadząca:
<c:forEach items="${p.therapistLastName}" var="p2">
    <c:out value="${p2} "/>
</c:forEach><br>

Usługa ważna od: <c:out value="${p.serviceBegin}"/><br>
Usługa ważna do: <c:out value="${p.serviceExpire}"/><br>


    <br />
    <a href="edit?idToEdit=${p.id}">
        Edytuj
    </a>
    </br />
    <a href="remove?idToRemove=${p.id}">
        Usuń
    </a>
    <p>

</c:forEach>

<br />
<a href="add">
    Dodaj nową osobę
</a>


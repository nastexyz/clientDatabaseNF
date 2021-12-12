<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Zmień dane</h2>

<form:form method="post" modelAttribute="therapist">

    Imię: <form:input path="therapistFirstName"/> <br /> <form:errors path="therapistFirstName"/> <br />
    Nazwisko: <form:input path="therapistLastName"/> <br /> <form:errors path="therapistLastName"/> <br />
    Login: <form:input path="login"/> <br /> <form:errors path="login"/> <br />
    Hasło: <form:password path="password"/> <br />

    <input type="submit" value="Wysyłam"> <br />

</form:form>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Zarejestruj się</h2>

<form:form modelAttribute="therapist">

    Imię: <form:input path="therapistFirstName"/> <br /> <form:errors path="therapistFirstName"/> <br />
    Nazwisko: <form:input path="therapistLastName"/> <br /> <form:errors path="therapistLastName"/> <br />
    Login: <form:input path="login"/> <br /> <form:errors path="login"/> <br />
    Hasło: <form:password path="password"/> <%--<br /> <form:errors path="password"/> <br />--%>

    <input type="submit" value="Wysyłam">

</form:form>
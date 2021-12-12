<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<strong> Dane klientki </strong> <br>

<form:form method="post" modelAttribute="person">

    Imię: <form:input path="firstName"/> <br /> <form:errors path="firstName"/> <br />
    Nazwisko: <form:input path="lastName"/> <br /> <form:errors path="lastName"/> <br />
    Adres: <form:input path="address"/> <br />
    Kod pocztowy: <form:input path="postcode"/> <br />
    Miejscowość: <form:input path="city"/> <br />
    Numer telefonu: <form:input path="phoneNumber" items=" "/> <br />
    Email: <form:input type="email" path="email"/> <br /> <form:errors path="email"/> <br />
    Data pierwszej wizyty: <form:input type="date" path="firstVisitDate"/> <br />
  <form:hidden path="id"/> Nazwa usługi: <form:select path="serviceName" items="${serviceName}" itemLabel="serviceName" itemValue="serviceName"/><br>
    <form:hidden path="id"/> Osoba prowadząca: <form:select path="therapistLastName" items="${therapistLastName}" itemLabel="therapistLastName" itemValue="therapistLastName"/><br>
   Usługa ważna od: <form:input type="date" path="serviceBegin"/> <br />
    Usługa ważna do: <form:input type="date" path="serviceExpire"/> <br />


    <input type="submit" value="Wysyłam"> <br />

</form:form>




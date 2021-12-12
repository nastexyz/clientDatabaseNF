<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form method="post" modelAttribute="service" action="/service/form/add">

    Kategoria usługi: <form:input path="serviceCategory"/> <br /> <form:errors path="serviceCategory"/> <br />
    Nazwa usługi <form:input path="serviceName"/> <br /> <form:errors path="serviceName"/> <br />

    <input type="submit" value="Wysyłam"> <br />

</form:form>

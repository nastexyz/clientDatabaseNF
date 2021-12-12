<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Czy na pewno chcesz usunąć klientkę z listy?</h2>

<form method="post">
    <input type="hidden" name="idToRemove" value="${person.id}">
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form>
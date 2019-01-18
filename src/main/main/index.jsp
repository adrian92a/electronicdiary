<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Home</title>
</head>


<nav class="navbar navbar-default">
    <div class="container-fluid">
       <div class="navbar-header">
            <a class="navbar-brand" href="/">Electronic Diary</a>
        </div>
        <ul class="nav navbar-nav">
        <c:when test="${not empty sessionScope.user}">
              <li><a href="/loginform">Zaloguj sie</a></li>
               <li><a href="/register">Utwórz konto</a></li>
               </c:when>
        </ul>
    </div>
</nav>

</body>
</html>


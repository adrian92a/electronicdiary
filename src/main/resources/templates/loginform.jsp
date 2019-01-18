<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<meta charset="UTF-8" />
<title>Please Login</title>
</head>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Electronic Diary</a>
        </div>
        <ul class="nav navbar-nav">
              <li><a href="/loginform">Zaloguj sie</a></li>
               <li><a href="/register">Utw�rz konto</a></li>
        </ul>
    </div>
</nav>

<body>
    <h1>Please Login</h1>
    <form  th:action="@{/processlogin}"  th:object="${userModel}" method="post">
        <input name="username" placeholder="Username" /> <br />
        <input name="password" placeholder="Password" /> <br />
        <input type="submit" value="Login" />
    </form>
</body>
</html>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>neural.net - Admin - Manage Users</title>
    <#include "style.ftlh">
</head>
<body>
    <#include "header.ftlh">
    <div class="container">
        <h1>Управление пользователями</h1>
        <#list users as usr>
            <ul>
                <li>${usr.getUsername()}</li>
                <li><a href="">Забанить</a></li>
            </ul>
        </#list>
    </div>

</body>
</html>
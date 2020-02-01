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
    <div class="container" style="line-height: 1.5">
        <h1>Управление пользователями</h1>
        <#list users as usr>
            <ul>
                <li>${usr.getUsername()}
                    <#if !usr.isAccountNonLocked()>
                        <div class="info" style="background-color: darkred">Banned</div>
                    </#if>
                </li>
                <li><a href="/admin/manage-users/ban?id=${usr.getId()}">Забанить</a></li>
            </ul>
        </#list>
    </div>

</body>
</html>
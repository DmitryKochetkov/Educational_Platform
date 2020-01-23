<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>neural.net - User Page</title>
    <#include "style.ftlh">
</head>
<body>
<#include "header.ftlh">
<section>
    <div class="container">
        <div class="cabinet">
            <h1>Личный кабинет</h1>

            <div class="cab__info">
                <img src="./img/default-user-image.png" alt="" id="avatar" width="150px">
                <div class="cab__info__inner">
                    <ul>
                        <li>Пользователь: ${principal.getUsername()}</li>
                        <li>Электронная почта: ${principal.getEmail()}</li>
                        <li><a href="/error" class="blue">Запросить смену пароля</a></li>
                        <li><a href="/logout">Выйти</a></li>
                    </ul>
                </div>

            </div>

            <div class="cab__info">
                <ul>
                    <li><a href="/user/articles" class="blue">Мои статьи</a></li>
                    <li><a href="/user/star" class="blue">Избранное</a></li>
                    <li><a href="/user/lessons" class="blue">Мои уроки</a></li>
                </ul>
            </div>

            <div class="cab__info">
                Аналитика:
                <ul>
                    <li>Подписчиков:</li>
                    <li>Статей:</li>
                    <li>Учеников:</li>
                    <li>Проведено уроков на портале:</li>
                </ul>
            </div>

        </div>
    </div>
</section>
</body>
</html>
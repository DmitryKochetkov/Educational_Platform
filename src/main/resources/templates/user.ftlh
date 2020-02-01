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
            <#if viewed?? && viewed.getUsername() == principal.getUsername()>
                <h1>Личный кабинет</h1>
                <#else><h1>Пользователь</h1>
            </#if>


            <div class="cab__info">
                <img src="./img/default-user-image.png" alt="" id="avatar" width="150px">
                <div class="cab__info__inner">
                    <ul>
                        <#if viewed?? && viewed.getUsername() == principal.getUsername()>
                                <li>Пользователь: ${principal.getUsername()}
                                    <#if is_admin>
                                        <div class="info">Admin</div>
                                        <#if !viewed.isAccountNonLocked()>
                                            <div class="info" style="background-color: darkred">Locked</div>
                                        </#if>
                                    </#if>
                                </li>
                                <li>Электронная почта: ${viewed.getEmail()}</li>

                            <#else>
                                <li>Пользователь: ${viewed.getUsername()}</li>
                                <li>Электронная почта: ${viewed.getEmail()}</li>


<#--                                <#if principal.getSubscribedTo()?seq_contains(viewed)>-->
<#--                                    <li><a href="/user/unsubscribe?author_id=${viewed.getId()}">Отписаться</a></li>-->
<#--                                    <li>${principal}</li>-->
<#--                                    <li>${viewed}</li>-->
<#--                                    <#else>-->
<#--                                    <li><a href="/user/subscribe?author_id=${viewed.getId()}">Подписаться</a></li>-->
<#--                                </#if>-->
                        </#if>
                        <#if viewed?? && viewed.getUsername() == principal.getUsername()>
                            <li><a href="/error" class="blue">Запросить смену пароля</a></li>
                            <li><a href="/logout">Выйти</a></li>
                        </#if>
                    </ul>
                </div>

            </div>

            <#if viewed?? && viewed.getUsername() == principal.getUsername()>
            <div class="cab__info">
                <ul>
                    <li><a href="/user/articles" class="blue">Мои статьи</a></li>
                    <li><a href="/user/star" class="blue">Избранное</a></li>
                    <li><a href="/user/courses" class="blue">Мои курсы</a></li>
                    <#if principal.getAuthoritiesStrings()?seq_contains("ROLE_ADMIN")>
                        <li><a href="/admin">Панель администратора</a></li>
                    </#if>
                    <li><a href="/user/delete-account">Удалить аккаунт</a></li>
                </ul>
            </div>
            </#if>

            Аналитика:
            <div class="cab__info">

                <ul>
                    <li>Подписчиков: ${viewed.getSubscribers()?size}</li>
                    <li>Статей: ${viewed.getArticles()?size}</li>
                    <li>Курсов: , учеников: </li>
                    <li>Проведено уроков на портале: </li>
                </ul>
            </div>

        </div>
    </div>
</section>
</body>
</html>
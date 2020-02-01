<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>neaural.net - My Articles</title>
    <#include "style.ftlh">
</head>
<body>
<#include "header.ftlh">

<section>
    <div class="container" style="line-height: 1.5">
        <h1>Мои статьи</h1>

        <ul class="article__list">
            <#if principal.getArticles()?size != 0>
                <#list principal.getArticles() as article>
                    <li><a href="/article?id=${article.getId()}">${article.getHeader()}</a> (обновлена ${article.getUpdated()})</li>
                </#list>

            <#else>
                <p><i>Нет статей :(</i></p>
            </#if>
        </ul>

        <br>

        <a href="/user/articles/edit">Создать статью</a>

        <br>
        <br>

        <h1>Мои курсы</h1>

        <ul class="article__list">
            <#if principal.getMyCourses()?size != 0>
                <#list principal.getMyCourses() as course>
                    <li><a href="/course?id=${course.getId()}">${course.getId()}</a> (обновлена ${course.getUpdated()})</li>
                </#list>

            <#else>
                <p><i>Нет курсов :(</i></p>
            </#if>
        </ul>
        <br>

        <a href="/user/courses/edit">Запустить курс</a>
    </div>
</section>

</body>
</html>
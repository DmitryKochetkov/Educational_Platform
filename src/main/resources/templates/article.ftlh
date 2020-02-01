<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>neural.net</title>
    <#include "style.ftlh">
    <link rel="stylesheet" href="/styles/prism.css">
    <script src="/js/prism.js"></script>
</head>
<body>
    <#include "header.ftlh">

    <section>


    </section>

    <div class="container">
        <div class="article">
            <h1>${article.getHeader()}</h1>
            <p class="article__info">Опубликовал <a href="/user?id=${article.getAuthor().getId()}">${article.getAuthor().getUsername()}</a> ${article.getCreatedFormatted()}</p>

            <div id="content">

            </div>

            <div class="after__article__info">
                <i class="fas fa-eye"></i> 0
                <i class="far fa-heart"></i> 0
            </div>
        </div>
    </div>

    <div class="container">
        <h1>Комментарии</h1>
    </div>

    <script>
        let xhr = new XMLHttpRequest();
        xhr.open('GET', '/repos/articles/${article.getContent_path()}');
        xhr.send();
        xhr.onload = function () {
            document.getElementById('content').innerHTML = xhr.response;
        }
    </script>

    <script src="/js/prism.js"></script>
</body>
</html>
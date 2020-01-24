<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>neural.net</title>
    <#include "style.ftlh">
</head>
<body>
    <#include "header.ftlh">
    <h1>Статья</h1>
    <#include "${root}${article.getContent_path()}">
</body>
</html>
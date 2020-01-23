<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>neural.net - Admin - Manage hashtag</title>
    <#include "style.ftlh">
</head>
<body>
    <#include "header.ftlh">
    <section>
        <div class="container">
            <h1>Управление сервисом: хештеги</h1>

            <div class="form__outer">
                Здесь можно добавить описание к хештегу.
                <form action="/admin/manage-hashtags/edit" method="post">
                    <div class="field">
                        <label for="hashtag_name">Хештег: </label>
                        <input type="text" name="hashtag_name">
                    </div>

                    <div class="field">
                        <label for="hashtag_description">Описание: </label>
                        <textarea name="hashtag_description" id="hashtag_description"></textarea>
                    </div>

                    <button type="submit">Сохранить изменения</button>
                </form>
            </div>

            <!--        TODO: script for searching hashtag-->

        </div>
    </section>
</body>
</html>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>neural.net - Editor</title>
    <#include "style.ftlh">
    <script src="https://cdn.tiny.cloud/1/zeh1mk4pppdr1bmwej4qod1hujgmu71142f1salp5swmhzcx/tinymce/5/tinymce.min.js" referrerpolicy="origin"/>
    <script>tinymce.init({
        selector: 'textarea',
        plugins: 'code'
    });</script>
</head>
<body>
    <#include "header.ftlh">
    <div class="container">
        <h1>Редактирование статьи</h1>
        <form action="/user/articles/save" method="post">

            <div class="field">
                <label for="header">Заголовок статьи: </label>
                <input type="text" name="header">
            </div>

            <div class="field">
                <label for="hashtag">Хештеги:</label>
                <input type="text" id="hashtag">
            </div>


            <div class="hashtags" id="hashtags"></div>
            <input type="hidden" name="hashtags" id="hashtag_json">


            <div class="field">
                Содержимое:
                <textarea name="file"></textarea>
            </div>

            <button type="submit" onclick="document.getElementById('hashtag_input')">Сохранить</button>
        </form>
    </div>

    <script>
        var hashtag = document.getElementById('hashtag');

        var hashtag_regExp = /(?:\s|^)#[A-Za-z0-9\-\.\_]+(?:\s|$)/;
        hashtag.onkeyup = function (event) {
            //TODO: search hashtags


            if (event.key === " ") {
                var res = hashtag_regExp.exec(hashtag.value);
                var area = document.getElementById('hashtags');

                if (res != null)
                {
                    var hashtag_array = area.getElementsByClassName('hashtag_text');
                    if (Array.isArray(hashtag_array) && hashtag_array.length) {
                        for (let i = 0; i < hashtag_array.length; i++) {
                            if (hashtag_array[i].textContent.includes(res[0])) return;
                        }
                    }
                    var divElement = document.createElement('div');
                    divElement.className = 'hashtag';
                    // divElement.innerText = res[0];
                    divElement.innerHTML += '<span class="hashtag_text">' + res[0] + '</span><a class="close" id="delete_hashtag" onclick="this.parentNode.parentNode.removeChild(this.parentNode)">&times;</a>';
                    area.appendChild(divElement);
                }
                hashtag.value = "";
            }
        }


    </script>

</body>
</html>
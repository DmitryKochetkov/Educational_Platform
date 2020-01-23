<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>neural.net - Free Education </title>
    <link rel="stylesheet" href="/styles/reset.css">
    <link rel="stylesheet" href="/styles/style.css">
    <link rel="stylesheet" href="/styles/prism.css">
    <script src="https://kit.fontawesome.com/f7eb5edd78.js" crossorigin="anonymous"></script>
    <script type="text/javascript" id="MathJax-script" async
            src="https://cdnjs.cloudflare.com/ajax/libs/mathjax/3.0.0/es5/latest?tex-mml-chtml.js">
    </script>
    <link href="https://fonts.googleapis.com/css?family=Fredoka+One|Merriweather|Merriweather+Sans|Nunito:700&display=swap" rel="stylesheet">
</head>
<body class="unselectable">

<header>
    <div class="container">
        <div class="header__inner">
            <div id="logo">
                <img src="/img/logo_icon.png" alt="">
                <a href="/">neaural.net</a>
            </div>

            <nav class="menu">
                <ul class="menu__list">
                    <li><a href="/">Главная</a></li>
                    <li><a href="/article">Статьи</a></li>
                    <li><a href="/forum">Форум</a></li>
                    <li><a href="/faq">F.A.Q.</a></li>
                </ul>
            </nav>

            <div id="login_section">
                <a id="login_button" href="/login">Войти</a>
            </div>
        </div>
    </div>
</header>

<script>
    var reg = document.getElementById("overlay_reg");
    var btn = document.getElementById("login_button");
    var close = document.getElementsByClassName("close")[0];
    btn.onclick = function () {
        reg.style.display = "block";
    };

    close.onclick = function () {
        reg.style.display = "none";
    };

    window.onclick = function (event) {
        if (event.target == reg) {
            reg.style.display = "none";
        }
    }
</script>
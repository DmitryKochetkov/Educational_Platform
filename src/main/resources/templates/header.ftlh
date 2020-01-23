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
                <#if principal?has_content>
                    <i class="fas fa-user"></i>
                    <a href="/user">${principal.getUsername()}</a>
                <#else>
                    <a id="login_button" href="/login">Войти</a>
                </#if>
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
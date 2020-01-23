<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Signup</title>
</head>
<body>
    <section>
        <div class="container">
            <h1>Регистрация</h1>
            <div class="form__outer">
                <form action="/signup/register" method="post" id="reg_form">
                    <div class="field">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email">
                    </div>

                    <div class="warning" id="occupied_email">
                        Пользователь с таким электронным адресом уже зарегистрирован!
                    </div>

                    <div class="field">
                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username">
                    </div>

                    <div class="warning" id="occupied_username">
                        Пользователь с таким ником уже зарегистрирован!
                    </div>

                    <div class="field">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password">
                    </div>

                    <div class="field">
                        <label for="repeat_password">Repeat Password:</label>
                        <input type="password" id="repeat_password" name="repeat_passwd">
                    </div>

                    <div class="field">
                        <label for="role">Role:</label>
                        <select name="role" id="role">
                            <option value="user">Обычный пользователь</option>
                            <option value="author">Автор</option>
                            <option value="tutor">Преподаватель</option>
                        </select>
                    </div>

                    <div class="warning" id="education_warning">
                        Для ученых степеней необходимо подтвердить статус документально.</div>

                    <div class="field">
                        <label for="education">Образование:</label>
                        <select name="education" id="education">
                            <option value="not_stated">Не выбрано</option>
                            <option value="preschooler">Дошкольник</option>
                            <option value="schooler">Школьник</option>
                            <option value="student">Студент</option>
                            <option value="bachelor">Бакалавр</option>
                            <option value="master">Магистр</option>
                            <option value="phd">Аспирант</option>
                            <option value="professor">Профессор</option>
                        </select>
                    </div>

                    <div class="field">
                        <label for="profession">Выберите интересные направления:</label>
                        <select name="profession" id="profession">
                            <option value="non-selected">Не выбрано</option>
                            <option value="no-job">Безработный</option>
                            <option value="no-job">IT</option>
                            <option value="no-job">Лингвистика</option>
                            <option value="no-job">Дизайн</option>
                            <option value="no-job">Искусство</option>
                            <option value="no-job">Наука</option>
                        </select>
                    </div>

                    <div class="field">
                        <label for="agree">Даю согласие на обработку персональных данных</label>
                        <input type="checkbox" id="agree" name="agree">
                    </div>

                    <button type="submit" id="register_button">Зарегистрироваться</button>
                </form>
            </div>
        </div>
    </section>

    <script>
        document.getElementById('education_warning').style.display = "none";
        document.getElementById('education').onchange = function () {
            if (document.getElementById('education').options.selectedIndex <= 3) {
                document.getElementById('education_warning').style.display = "none";
                //studying
            }
            else document.getElementById('education_warning').style.display = "block";
        }

        // var button = document.getElementById('register_button');
        // button.onclick = function() {
        //     var field_password = document.getElementById('password');
        //     var field_repeat_password = document.getElementById('repeat_password');
        //     if (field_password.value == field_repeat_password.value)
        //         document.getElementById('reg_form').submit();
        //
        // }
    </script>
</body>
</html>
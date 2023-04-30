<#import "parts/templadmin.ftl" as p>
<@p.pages>
    <h1> Auth </h1>

    <hr>
    <form action="/login" method="post">

        <label for="username">Username</label>
        <input type="text" name="username" placeholder="user"><br>

        <label for="password">Password</label>
        <input type="password" name="password" placeholder="password"><br>

        <input type="submit" value="add">

    </form>
    <a href="/registration">Перехід на сторінку реєстрації</a>

</@p.pages>
<html>
<body>
<main class="form-signin w-100 m-auto">
    <form action="/my-registration.process.jsp" method="POST">
        <h1 class="h3 mb-3 fw-normal">Please enter your login and password</h1>

        <div class="form-floating">
            <input name="login" type="text" class="form-control" id="floatingInput">
            <label for="floatingInput">Login</label>
        </div>
        <div class="form-floating">
            <input name="password" type="text" class="form-control" id="floatingPassword">
            <label for="floatingPassword">Password</label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Enter</button>
    </form>
</main>
</body>
</html>

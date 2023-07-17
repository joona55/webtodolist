<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <title> Login Page </title>
    </head>
    <body>
        <div class="container">
            <h1>Login page view.</h1>
            <pre>${errorMessage}</pre>
            <form method="post">
                <div> Name : <input type="text" name="name"> </div>
                <div> Password : <input type="password" name="password"> </div>
                <input type="submit">
            </form>
        </div>

        <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"> </script>
        <script src="webjars\jquery\3.6.0\jquery.min.js"> </script>
    </body>
</html>
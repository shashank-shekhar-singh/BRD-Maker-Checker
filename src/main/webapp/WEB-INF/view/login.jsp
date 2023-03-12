<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <%@include file="./base.jsp" %>
    </head>

    <body class="bg-image" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/76.jpg');
           height: 100vh">

        <nav class="navbar navbar-dark bg-dark light-green lighten-4 text-white mb-4">
            <h2>Maker Checker</h2>
        </nav>

        <div class="container card col-md-4 bg-dark text-white">
            <div class="container mt-3 text-center">
                <h2>Login</h2>
                <!-- <hr class="hr bg-white"> -->
            </div>
            <div class="container mt-3">
                <form action="login" method="post">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" name="username" class="form-control" id="username"
                            aria-describedby="emailHelp" placeholder="johndoe12">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control" id="password" placeholder="abc@123">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block mt-4 mb-4">Log in</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- <div class="container mt-5">
            <h4>Don't have an account?</h4>
            <p>Create One</p>
            <%-- <form action="/MakerChecker/signup">--%>
                <a href="signup"> <button class="btn btn-primary">Sign Up</button> </a>
                </form>
        </div> -->
    </body>

    </html>
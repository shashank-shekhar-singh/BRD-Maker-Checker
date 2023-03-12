<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container mt-3 text-center">
    <%--    <div class="container mt-3">--%>
    <h2>Sign Up</h2>
    <%--        <hr>--%>
</div>
<div class="container mt-5">
    <form action="registerUser" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="first_name">First Name</label>
                <input type="text" name="firstName" class="form-control" id="first_name" placeholder="First name">
            </div>

            <div class="form-group col-md-6">
                <label for="last_name">Last Name</label>
                <input type="text" name="lastName" class="form-control" id="last_name" placeholder="Last name">
            </div>

            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="email" name="email" class="form-control" id="inputEmail4" placeholder="Email">
            </div>

            <div class="form-group col-md-6">
                <label for="inputPassword4">Password</label>
                <input type="password" name="password" class="form-control" id="inputPassword4" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <label for="accountType">Account Type</label>
            <select id="accountType" name="accountType" class="form-control">
                <option selected>Choose...</option>
                <option value="maker">Maker</option>
                <option value="checker">Checker</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>

</body>
</html>
        <%--            <div class="form-group">--%>
        <%--                <label for="inputAddress">Address</label>--%>
        <%--                <input type="text" name="address" class="form-control" id="inputAddress" placeholder="Address">--%>
        <%--            </div>--%>
        <%--            <div class="form-group">--%>
        <%--                <label for="inputAddress2">Address 2</label>--%>
        <%--                <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">--%>
        <%--            </div>--%>
        <%--            <div class="form-row">--%>
        <%--                <div class="form-group col-md-6">--%>
        <%--                    <label for="inputCity">City</label>--%>
        <%--                    <input type="text" class="form-control" id="inputCity">--%>
        <%--                </div>--%>
        <%--            <div class="form-group col-md-4">--%>



        <%--                <div class="form-group col-md-2">--%>
        <%--                    <label for="inputZip">Zip</label>--%>
        <%--                    <input type="text" class="form-control" id="inputZip">--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--            <div class="form-group">--%>
        <%--                <div class="form-check">--%>
        <%--                    <input class="form-check-input" type="checkbox" id="gridCheck">--%>
        <%--                    <label class="form-check-label" for="gridCheck">--%>
        <%--                        Check me out--%>
        <%--                    </label>--%>
        <%--                </div>--%>
        <%--            </div>--%>

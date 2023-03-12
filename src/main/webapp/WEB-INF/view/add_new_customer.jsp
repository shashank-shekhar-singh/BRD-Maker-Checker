<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="./base.jsp" %>
</head>

<body class="bg-image" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/76.jpg');
height: 100vh">
    <%@include file="./navbar.jsp" %>

    <div class="container mt-3">
        <div class="row">
            <div class="col-md-6 offset-md-3 card  bg-dark text-white">
                <h1 class="text-center mt-3 mb-3">Add Customer</h1>
                <form action="create" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="first_name">First Name</label>
                            <input type="text" class="form-control" id="first_name" name="firstName"
                                placeholder="John">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="last_name">Last Name</label>
                            <input type="text" class="form-control" id="last_name" name="lastName"
                                placeholder="Doe">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="address1">Address</label>
                        <input type="text" class="form-control" id="address1" name="address1"
                            placeholder="1234 Main St">
                    </div>
                    <div class="form-group">
                        <label for="address2">Address 2</label>
                        <input type="text" class="form-control" id="address2" name="address2"
                            placeholder="Apartment, studio, or floor">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Email</label>
                            <input type="email" class="form-control" id="inputEmail4" name="email"
                                placeholder="john123@gmail.com">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="contact_number">Contact Number</label>
                            <input type="text" class="form-control" id="contact_number" name="contactNumber"
                                placeholder="1234567890">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="pin_code">Pin Code</label>
                            <input type="text" class="form-control" id="pin_code" name="pincode"
                                placeholder="277001">
                        </div>
                        <!-- <div class="form-group col-md-4">
                            <label for="inputState">State</label>
                            <select id="inputState" class="form-control">
                                <option selected>Choose...</option>
                                <option>...</option>
                            </select>
                        </div> -->
                    </div>
                    <div class="form-group">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="activeFlag" id="active" value="1"
                                checked>
                            <label class="form-check-label" for="active">Active</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="activeFlag" id="inactive" value="0">
                            <label class="form-check-label" for="inactive">Inactive</label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Add</button>
                </form>
            </div>
        </div>
    </div>

</body>

</html>
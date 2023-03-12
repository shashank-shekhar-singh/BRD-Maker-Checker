<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="./base.jsp" %>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.3/css/jquery.dataTables.min.css">
        <script src="https://cdn.datatables.net/1.13.3/js/jquery.dataTables.min.js"></script>
</head>

<body class="bg-image" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/76.jpg');
height: 100vh">
    <%@include file="./navbar.jsp" %>
    <div class="container-fluid mt-3">
        <div class="row">
            <div class="col-md-12">
                <!-- <div class="container-fluid">

                </div> -->
                <h1 class="float-left">Users</h1>
                <a href="tempCustomer/add-new-customer" class="btn btn-primary float-right mt-1">Add New
                    Customer</a>

                <!-- <hr class="float-center"> -->

                <table id="myTable" class="table table-striped table-bordered table-dark">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Email</th>
                            <th scope="col">Contact</th>
                            <th scope="col">Roles</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <th scope="row">${user.userId}</th>
                                <td scope="row">${user.firstName}</td>
                                <td scope="row">${user.lastName}</td>
                                <td scope="row">${user.email}</td>
                                <td scope="row">${user.phoneNumber}</td>
                                <td scope="row">
                                    <c:forEach items="${user.roles}" var="role">
                                        <p class="text-lowercase">
                                            ${role.name}
                                        </p>
                                    </c:forEach>
                                </td>
                                <td scope="row">
                                    <a class="mr-3" href="tempCustomer/update/${ct.id}"><i
                                            class="fa-solid fa-pen-to-square text-primary"></i></a>
                                    <a href="tempCustomer/delete/${ct.id}"><i
                                            class="fa-solid fa-trash-can text-danger"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $('#myTable').DataTable();
            $('.dataTables_length').addClass('bs-select');
        });
    </script>
</body>

</html>
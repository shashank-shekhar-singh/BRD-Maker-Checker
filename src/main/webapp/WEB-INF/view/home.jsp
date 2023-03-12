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
                <div class="">
                    <div class="float-left">
                        <h1 class="">New Customers</h1>
                    </div>
                    <c:if test="${isMaker}">
                        <div class="float-right">
                            <a href="tempCustomer/add-new-customer" class="btn btn-primary mt-1">Add New
                                Customer</a>
                        </div>
                    </c:if>
                </div>

                <!-- <hr class="col-md-12"> -->

                <table id="myTable" class="table table-striped table-bordered table-dark">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Email</th>
                            <th scope="col">Contact</th>
                            <th scope="col">Created date</th>
                            <th scope="col">CreatedBy</th>
                            <th scope="col">Modified date</th>
                            <th scope="col">ModifiedBy</th>
                            <th scope="col">Status</th>
                            <th scope="col">Actions&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${tempCustomers}" var="ct">
                            <tr>
                                <th scope="row">${ct.id}</th>
                                <td scope="row">${ct.firstName}</td>
                                <td scope="row">${ct.lastName}</td>
                                <td scope="row">${ct.email}</td>
                                <td scope="row">${ct.contactNumber}</td>
                                <td scope="row">${ct.createdDate}</td>
                                <td scope="row">${ct.createdBy}</td>
                                <td scope="row">${ct.modifiedDate}</td>
                                <td scope="row">${ct.modifiedBy}</td>
                                <td scope="row">${ct.recordStatus}</td>
                                <td scope="row">
                                    <c:if test="${isMaker}">
                                        <a class="mr-3" href="tempCustomer/update/${ct.id}"><i
                                            class="fa-solid fa-pen-to-square text-primary"></i></a>
                                        <a href="tempCustomer/delete/${ct.id}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"><i
                                            class="fa-solid fa-trash-can text-danger"></i></a>
                                    </c:if>
                                    <c:if test="${isChecker && currentUserId != c.modifiedBy}">
                                        <a class="ml-2" href="checker/approve/${ct.id}"><i
                                                class="fa-solid fa-check text-success btn-lg p-0"></i></a>
                                        <a class="ml-2" href="checker/reject/${ct.id}"><i
                                                class="fa-sharp fa-solid fa-xmark text-warning btn-lg p-0"></i></a>
                                    </c:if>
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
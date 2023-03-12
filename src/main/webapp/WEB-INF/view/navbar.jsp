<nav class="navbar navbar-dark bg-dark light-green lighten-4">

    <!-- Collapse button -->
    <button class="navbar-toggler toggler-example" type="button" data-toggle="collapse"
        data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false"
        aria-label="Toggle navigation"><span class="dark-blue-text">
            <i class="fas fa-bars fa-1x"></i></span>
    </button>

    <div class="">
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="submit" class="" value="Log Out" />
        </form>
    </div>
    <!-- <a class="navbar-brand" href="${pageContext.request.contextPath}/logout">Logout</a> -->

    <!-- Collapsible content -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent1">
        <!-- Links -->
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/">New Customers<span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/authorized-customers">Authorized
                    Customers</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/users">Users</a>
            </li>
        </ul>
        <!-- Links -->
    </div>
    <!-- Collapsible content -->
    <!-- Navbar brand -->
</nav>
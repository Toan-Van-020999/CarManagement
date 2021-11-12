
<%@page import="model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page import="dao.CustomerDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Customer Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            Employee e = (Employee) session.getAttribute("employee");
            if (e == null) {
                response.sendRedirect("Login.jsp?err=timeout");
            }
            String name = request.getParameter("searchCustomer");
            CustomerDAO customerDAO = new CustomerDAO();
            List<Customer> customers = customerDAO.getCustomer(name);
            session.setAttribute("customers", customers);

        %>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="SearchCarView.jsp">Car</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">

                    <form action="SearchCustomerView.jsp" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="searchCustomer" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Enter name...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Quality reputable car rental shop</h1>
                <p class="lead text-muted mb-0">Prestige creates a brand with more than 10 years of supplying famous car brand products in the world</p>
            </div>
        </section>
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="row">
                        <table style="width:100%">
                            <tr> 
                                <th>Number</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Phone</th>
                                <th>IdCard</th>
                                <th>Note</th>
                                <th>Description</th>
                                <th>License</th>
                            </tr>
                        </table>
                        
                        <c:forEach items="${customers}" var="o">
                            <table style="width:100%">
                                <tr>
                                    <td>${o.id}</td>
                                    <td>${o.name}</td>
                                    <td>${o.address}</td>
                                    <td>${o.phoneNumber}</td>
                                    <td>${o.idCard}</td>
                                    <td>${o.note}</td>
                                    <td>${o.description}</td>
                                    <td>${o.license}</td>
                                    <td><a  href="SearchCarView.jsp?id=${o.id}" class="btn btn-success btn-block">Select</a></td>
                                </tr>
                            </table>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


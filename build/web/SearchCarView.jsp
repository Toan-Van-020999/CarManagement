<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Employee"%>
<%@page import="model.Car"%>
<%@page import="java.util.List"%>
<%@page import="dao.CarDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Car Page</title>

        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <%
            String id = request.getParameter("id");
            session.setAttribute("idCustomer", request.getParameter("id"));

            Employee e = (Employee) session.getAttribute("employee");
            if (e == null) {
                response.sendRedirect("Login.jsp?err=timeout");
            }
            CarDAO carDAO = new CarDAO();
            List<Car> listCar;
            String fromDate = request.getParameter("fromDate");
            String toDate = request.getParameter("toDate");
            String type = request.getParameter("type");
            if (fromDate != null && toDate != null && type != null) {
                listCar = carDAO.searchCar(new SimpleDateFormat("yyyy-MM-dd").parse(fromDate), new SimpleDateFormat("yyyy-MM-dd").parse(toDate), type);
                session.setAttribute("listC", listCar);
            }
            
            String car_id = "";
            if (request.getCookies() != null) {
                Cookie[] cookie = request.getCookies();
                for (Cookie c : cookie) {
                    if (c.getName().equals("car_id")) {
                        car_id = c.getValue();
                    }
                }
            }
            if (car_id != "") {
                session.setAttribute("idSelectedCar", car_id);
            }

        %>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="HomePageView.jsp">Car</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <form action="SearchCarView.jsp" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input style ="margin-right:20px " name="fromDate" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="From Date...">
                            <input style ="margin-right:20px " name="toDate" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="To Date...">
                            <input name="type" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Type...">
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
                        <c:forEach items="${listC}" var="o">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="#" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.description}
                                        </p>
                                        <div class="row">

                                            <div class="col">
                                                <a onclick="getConfirmation(${o.id});" style="color: white" data-target="#selectCar" class="btn btn-success btn-block" data-toggle="modal">SELECT</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="selectCar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Select Car</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Do you want to continue choosing a car?</p>
                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                    </div>
                    <div class="modal-footer">
                        <button  type="button" class="btn btn-secondary" data-dismiss="modal">Continue</button>
                        <button onclick="directional();" type="button" class="btn btn-primary" data-dismiss="modal">Done</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <script type = "text/javascript">

        function directional() {
            window.location.assign("RentalContractView.jsp");
        }

        function setCookie(cname, cvalue, exdays) {
            if (getCurrentCookie != null)
                cvalue += ("x" + getCurrentCookie());
            const d = new Date();
            d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
            let expires = "expires=" + d.toUTCString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
        }

        function getConfirmation(cvalue) {
            setCookie("car_id", cvalue, 365);
        }

        function getCurrentCookie() {
            var allcookies = document.cookie;
            var value = "";
            cookiearray = allcookies.split(';');
            for (var i = 0; i < cookiearray.length; i++) {
                name = cookiearray[i].split('=')[0];
                if (name == "car_id") {
                    value = cookiearray[i].split('=')[1];
                    return value;
                }
            }
            return value;
        }
    </script>
</html>


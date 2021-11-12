<%@page import="dao.CarDAO"%>
<%@page import="model.Car"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="dao.EmployeeDAO"%>
<%@page import="model.Employee"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rental Contract Page</title>
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

            // get customer by id
            String idC = (String) session.getAttribute("idCustomer");
            CustomerDAO cdao = new CustomerDAO();
            Customer customer = cdao.getCustomerById(idC);
            String idSelectedCar = (String) session.getAttribute("idSelectedCar");
            List<Car> listCar = new ArrayList<>();
            String[] idCar = null;
            if(idSelectedCar.contains("x")){
                idCar = idSelectedCar.split("x");
            }else{
                idCar[0] = idSelectedCar;
            }
            CarDAO carDAO = new CarDAO();
            for (int i = 0; i < idCar.length; i++) {
                Car car = carDAO.getCarById(idCar[i]);
                listCar.add(car);
            }
            session.setAttribute("listCar", listCar);
            

        %>

        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="HomePageView.jsp">Car</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Quality reputable car rental shop</h1>
                <p class="lead text-muted mb-0">Prestige creates a brand with more than 10 years of supplying famous car brand products in the world</p>
            </div>
        </section>

        <div class="main container">
            <h3 class="align">Hợp đồng cho khách thuê xe</h3>
            <h5 class="info">
                Anh : <%=customer.getName()%><br>
                Địa chỉ : <%=customer.getAddress()%><br>
                Số CMT : <%=customer.getIdCard()%><br>
                Số điện thoại : <%=customer.getPhoneNumber()%><br>
                Bằng lái xe : <%=customer.getLicense()%>
            </h5>
            <div>
                <%
                    int i = 1;
                %>
                <h5>Bảng xe khách chọn</h5>
                <table class="table table-bordered">
                    <thead class="table-light">
                        <tr>
                            <th>Number</th>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>License plate</th>
                            <th>Brand</th>
                            <th>The Firm</th>
                            <th>Color</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Price</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listCar}" var="o">
                            <tr>
                                <td><%= i++%></td>
                                <td>${o.id}</td>
                                <td>${o.name}</td>
                                <td><img class="card-img-top" src="${o.image}" alt="Card image cap"></td>
                                <td>${o.licensePlate}</td>
                                <td>${o.brand}</td>
                                <td>${o.theFirm}</td>
                                <td>${o.color}</td>
                                <td>${o.description}</td>
                                <td>${o.status}</td>
                                <td>${o.price}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="flex" style="margin-bottom: 10px">
                    <h5>Tiền đặt cọc :</h5>
                    <input >
                </div>
                <table class="table table-bordered">
                    <thead class="table-light">
                        <tr>
                            <th>STT</th>
                            <th>Tên tài sản</th>
                            <th>Số lượng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>

                            </td>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <td>

                            </td>
                            <td>

                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="align">
                    <button class="btn btn-outline-primary" type="button">Thêm thế chấp</button>
                </div>
                <div style ="margin-top: 20px;margin-bottom: 20px"   class="justi flex">
                    <button class="btn btn-secondary" type="button">Hủy bỏ</button>
                    <button class="btn btn-success " type="button">Tạo hợp đồng</button>
                </div>
            </div>
        </div>
    </body>
</html>

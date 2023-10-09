<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous" defer></script>
                <script src="https://kit.fontawesome.com/e136359f35.js" crossorigin="anonymous" defer></script>
                <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js" defer></script>
            </head>

            <body>

                <jsp:include page="common/header.jsp"></jsp:include>

                <!-- modal -->
                <jsp:include page="common/login-modal.jsp"></jsp:include>

                <h1 class="my-3">${message}</h1>

                <div class="container">
                    <div class="row pt-5">
                        <div class="d-flex align-items-center justify-content-between border-bottom border-3 border-dark px-0 mb-3">
                            <h2 class="fw-bold"><i class="fa-brands fa-accusoft me-3"></i>Product Cart</h2>
                        </div>
                    </div>
                    <div class="row" id="listCart">
                        <table class="table">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col" style="width: 5%;">ID</th>
                                    <th scope="col" style="width: 30%;">Name</th>
                                    <th scope="col" style="width: 20%;">Price</th>
                                    <th scope="col" style="width: 15%;">Quantity</th>
                                    <th scope="col" style="width: 20%;">Amount</th>
                                    <th scope="col" style="width: 10%;"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="prod" items="${cart}" varStatus="loop">
                                    <tr>
                                        <td>${prod.value.id}</td>
                                        <td class="w-25">
                                            <img class="img-fluid me-2" alt="" src="/images/${prod.value.image}" style="height: 40px">
                                            ${prod.value.name}
                                        </td>
                                        <td><fmt:formatNumber type="number" value="${prod.value.price}"/> VND</td>
                                        <td>
                                            <input class="w-75 m-auto quantityProd" type="number" name="quantity" value="${prod.value.quantity}">
                                        </td>
                                        <td><fmt:formatNumber type="number" value="${prod.value.price * prod.value.quantity}" /> VND</td>
                                        <td><a href="/cart/remove/${prod.value.id}" class="btn btn-danger">Remove</a></td>
                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="d-flex justify-content-between pt-2 border-top border-dark border-3">
                            <div>
                                <a href="/products" class="btn btn-primary">Go Menu Product</a>
                                <a href="/cart/clear" class="btn btn-danger ms-3">Clear All</a>
                            </div>
                            <div>
                                <span class="fw-bold fs-5">Tổng tiền: </span>
                                <span class="fs-5"><fmt:formatNumber type = "number" value = "${amount}"/> VND</span>
                            </div>
                        </div>
                    </div>
                </div>

                <script>
                    if ("${message}" != "") alert("${message}");
                    
                </script>
            </body>

            </html>
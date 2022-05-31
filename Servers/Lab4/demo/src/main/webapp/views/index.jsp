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

                <h2 class="my-3 text-success">${message}</h2>

                <div id="tag-cart" class="my-3">
                    <a class="btn btn-outline-dark" href="/cart/view">
                        <i class="fa-solid fa-cart-shopping"></i>
                        Cart
                        <span class="badge bg-dark text-white ms-1 rounded-pill" id="cartQuantity">${cartQuantity}</span>
                        | <span id="cartQuantity">
                            <fmt:formatNumber type="number" value="${cartAmount}" /> VNĐ
                        </span>
                    </a>
                </div>

                <div class="row my-3" id="listProd">
                    <c:forEach var="prod" items="${products}" varStatus="loop">
                        <div class="col">
                            <div class="card mb-3" style="width: 18rem">
                                <img src="/images/${prod.image}" class="card-img-top" alt="..." />
                                <div class="card-body">
                                    <h5 class="card-title">${prod.name}</h5>
                                    <p class="card-text">
                                        Price:
                                        <span class="fw-bold">
                                            <fmt:formatNumber type="number" value="${prod.price}" /> VND
                                        </span><br>
                                        Remain:
                                        <span class="fw-bold">
                                            ${prod.quantity}
                                        </span>
                                    </p>
                                    <a href="#" class="btn btn-primary">Buy</a>
                                </div>
                                <div class="card-footer d-flex justify-content-between bg-transparent border-0 mb-2">
                                    <button class="btn btn-dark" onclick="addProduct('${prod.id}')">Add to cart</button>
                                    <a href="" class="btn btn-secondary">Detail</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>


                <script type="text/javascript">
                    if ("${message}" != "") alert("${message}");
                    function addProduct(id) {
                        fetch('/cart/add/' + id)
                            .then(function (res) {
                                return res.text()
                            }).then(function (html) {
                                let parser = new DOMParser()
                                let doc = parser.parseFromString(html, 'text/html')
                                document.querySelector('#listProd').innerHTML = doc.documentElement.querySelector('#listProd').innerHTML
                                document.querySelector('#tag-cart').innerHTML = doc.documentElement.querySelector('#tag-cart').innerHTML
                            }).catch(error => {
                                console.error('There has been a problem with your fetch operation:', error);
                            });
                    }
                </script>
            </body>

            </html>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
            </head>

            <body>
                <div class="container">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col"><a href="/product/sort?field=id">ID</a></th>
                                <th scope="col"><a href="/product/sort?field=name">Name</a></th>
                                <th scope="col"><a href="/product/sort?field=price">Price</a></th>
                                <th scope="col"><a href="/product/sort?field=createDate">Date</a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${page.content}" varStatus="loop">
                                <tr>
                                    <th scope="row">${item.id}</td>
                                    <td>${item.name }</td>
                                    <td>${item.price }</td>
                                    <td>${item.createDate }</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <nav>
                        <ul class="pagination justify-content-center">
                            <li class="page-item"><a class="page-link" href="/product/page?page=0">First</a></li>
                            <li class="page-item"><a class="page-link" href="/product/page?page=${page.number - 1}">Prev</a></li>
                            <li class="page-item"><a class="page-link" href="/product/page?page=${page.number + 1}">Next</a></li>
                            <li class="page-item"><a class="page-link" href="/product/page?page=${page.totalPages - 1}">Last</a></li>
                        </ul>
                    </nav>
                    <ul class="list-group">
                        <li class="list-group-item">Current Element count: ${page.numberOfElements}</li>
                        <li class="list-group-item">Page number: ${page.number}</li>
                        <li class="list-group-item">Size: ${page.size}</li>
                        <li class="list-group-item">Total Elements: ${page.totalElements}</li>
                        <li class="list-group-item">Total pages: ${page.totalPages}</li>
                    </ul>
                </div>
            </body>

            </html>
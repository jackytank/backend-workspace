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
                            <c:forEach var="item" items="${products}" varStatus="loop">
                                <tr>
                                    <th scope="row">${item.id}</td>
                                    <td>${item.name }</td>
                                    <td>${item.price }</td>
                                    <td>${item.createdate }</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </body>

            </html>
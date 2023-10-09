<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Insert title here</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
        <link rel="stylesheet" href="./css/style.css">
    </head>

    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <div class="container">
                    <div class="columns is-centered mt-6">
                        <div class="column is-5">
                            <div class="card pt-1">
                                <div class="content has-text-centered mt-5">
                                    <p class="title">${item.name}</p>
                                </div>
                                <div class="card-image">
                                    <figure class="image is-4by3">
                                        <img src="${item.image}" alt="">
                                    </figure>
                                </div>
                                <div class="card-content">
                                    <div class="content">
                                        <ul>
                                            <li>Giá gốc: <s>${item.price}</s></li>
                                            <li>Giá mới: <c:set var="newprice"
                                                    value="${item.price*(1-item.discount)}"></c:set>
                                                <fmt:formatNumber value="${newprice}"></fmt:formatNumber>
                                            </li>
                                            <li>Mức giá:
                                                <c:choose>
                                                    <c:when test="${newprice<10}">Giá thấp</c:when>
                                                    <c:when test="${newprice>100}">Giá cao</c:when>
                                                    <c:otherwise>Bình thường</c:otherwise>
                                                </c:choose>
                                            </li>
                                        </ul>
                                    </div>
                                    <hr>
                                    <div class="content">
                                        <p>Ngày:${item.date}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
    </body>

    </html>
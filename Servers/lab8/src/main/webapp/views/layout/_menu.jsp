<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
                <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>


                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Document</title>
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
                    </head>

                    <body>

                        <nav class="row navbar navbar-expand-lg navbar-light border">
                            <div class="container-fluid">
                                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav"
                                    aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="navbar-collapse collapse" id="navbarNav">
                                    <ul class="navbar-nav">
                                        <li class="nav-item">
                                            <a class="nav-link active" aria-current="page" href="/home/index">
                                                <s:message code="lo.mn.home" />
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="/home/about">
                                                <s:message code="lo.mn.about" />
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="?lang=vi">Tieng Viet</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="?lang=en">English</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </nav>

                        <script>
                            $(document).ready(function () {
                                $("a[href*=lang]").on("click", function () {
                                    var param = $(this).attr("href");
                                    $.ajax({
                                        url: "/home/index" + param,
                                        success: function () {
                                            location.reload();
                                        }
                                    });
                                    return false;
                                })
                            })
                        </script>
                    </body>

                    </html>
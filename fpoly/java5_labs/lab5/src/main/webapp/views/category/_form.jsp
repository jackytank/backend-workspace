<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                <h3>EDIT CATEGORY</h3>
                <form:form action="/category/index" method="post" modelAttribute="category">
                    <div class="form-group mb-3">
                        <form:label path="id">Category ID: </form:label>
                        <form:input path="id" class="form-control" type="text" />
                    </div>
                    <div class="form-group mb-3">
                        <form:label path="name">Category Name</form:label>
                        <form:input path="name" class="form-control" type="text" />
                    </div>
                    <button class="btn btn-success" formaction="/category/create" formmethod="post">CREATE</button>
                    <button class="btn btn-secondary" formaction="/category/update" formmethod="post">UPDATE</button>
                    <button class="btn btn-danger" formaction="/category/delete/${category.id}" formmethod="get">DELETE</button>
                    <button class="btn btn-info" formaction="/category/index">RESET</button>
                </form:form>
            </div>
        </body>

        </html>
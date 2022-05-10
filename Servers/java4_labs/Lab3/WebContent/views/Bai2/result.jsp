<%@ page pageEncoding="utf-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    </head>

    <body>
        <div class="columns is-centered mt-6">
            <div class="column">
                <div class="content">
                    <ul>
                        <li>Fullname: <b>${bean.fullname}</b></li>
                        <li>Photo: <b>${bean.photo}</b></li>
                        <li>Birthday: <b>${bean.birthday}</b></li>
                        <li>Gender : <b>${bean.gender}</b></li>
                        <li>Country : <b>${bean.country}</b></li>
                        <li>Marriage: <b>${bean.married}</b></li>
                        <li>Hobbies : <b>${bean.hobbies}</b></li>
                        <li>Notes : <b>${bean.notes}</b></li>
                    </ul>
                </div>
            </div>
        </div>
    </body>

    </html>
<%@ page pageEncoding="utf-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous" />
    </head>

    <body>
        <h2>1. Photo ${img.name}</h2>
        <img src="/Lab3/files/${img.name}" height="100" alt="">

        <h2>2. Document: ${doc.name}</h2>
        <a href="/Lab3/files/${doc.name}">Download</a>
    </body>

    </html>
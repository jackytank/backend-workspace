<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    </head>
    </head>

    <body>
        <div class="container">
            <div class="columns is-centered mt-6">
                <div class="column is-4">
                    <h1 class="block title has-text-centered">SEND MAIL</h1>
                    <form action="/thelab3/mail" method="post" class="box" id="form-login">
                        <div class="field">
                            <label for="" class="label">To</label>
                            <div class="control has-icons-left">
                                <input type="email" class="input" name="tomail">
                            </div>
                        </div>
                        <div class="field">
                            <label for="" class="label">Subject</label>
                            <div class="control has-icons-left">
                                <input type="text" class="input" name="subject">
                            </div>
                        </div>
                        <div class="field">
                            <label for="" class="label">Body</label>
                            <div class="control has-icons-left">
                                <textarea class="textarea" name="body" id="" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <hr>
                        <div class="field">
                            <div class="control">
                                <button class="button is-fullwidth is-primary" type="submit">Send</button>
                            </div>
                        </div>
                        <mark>${message}</mark>
                    </form>
                </div>
            </div>
        </div>
    </body>

    </html>
<div class="modal fade align-items-center justify-content-center" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content p-3">
            <div class="modal-header border-dark border-3">
                <h5 class="model-title fw-bold" id="loginModalLabel">LOGIN</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/account/login" method="post">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" name="username" id="username" value="${cookie.username.value}" placeholder="Username">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="username" name="password" value="${cookie.password.value}" placeholder="Password">
                    </div>
                    <div class="mb-3 form-check">
                        <c:choose>
                            <c:when test="${cookie.remember == null}">
                                <input type="checkbox" class="form-check-input" id="remember" name="remember" value="true">
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" class="form-check-input" id="remember" name="remember" value="true" checked>
                            </c:otherwise>
                        </c:choose>
                        <label class="form-check-label" for="remember">Remember me?</label>
                    </div>

                    <button class="btn btn-success w-100 mt-2" type="submit">Login</button>
                </form>
            </div>
        </div>
    </div>
</div>
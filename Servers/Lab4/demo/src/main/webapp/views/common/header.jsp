<header class="sticky-top">
    <div class="info-bar border-bottom">
        <div class="container d-flex justify-content-between align-items-center p-1">
            <div class="">
                <span class="ibar-title"><i class="fa-solid fa-phone-volume me-2"></i>Hotline:</span>
                <span class="me-2"> 0123456789</span>|
                <span class="ibar-title"><i class="fa-brands fa-facebook-f me-2"></i> Facebook: </span>
                <a class="me-2">ShopPT</a>|
                <span class="ibar-title"><i class="fa-solid fa-language me-2"></i> Language:</span>
                <select class="rounded mx-2 bg-transparent border-0 text-center">
                    <option value="en">English</option>
                    <option value="vn">Vietnamese</option>
                </select>
            </div>
            <div class="">
                <c:choose>
                    <c:when test="${sessionScope.username!=null}">
                        <div class="nav-item dropdown d-inline-flex ">
                            <a class="nav-link ibar-title py-0 dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-expanded="false">
                                <i class="fa-solid fa-user me-2"></i> Hi, Tri
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">User Profile</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/account/logout">Logout</a>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <a class="ibar-title me-3" href="" data-bs-toggle="modal" data-bs-target="#loginModal">Login</a>|
                        <a href="#" class="ibar-title">Register</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</header>
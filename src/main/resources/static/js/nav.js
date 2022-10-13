const createNav = () => {
    let nav = document.querySelector('.navbar');

    nav.innerHTML = `
        <div class="nav">
            <img src="img/dark-logo.png" class="brand-logo" alt="">
            <div class="nav-items">
                <form class="search"  action="#" th:action="@{/searchBarForm}" th:object="&dollar{bar}" method="post">
                    <input type="text" class="search-box" th:field="*{bar}" placeholder="search brand, product">
                    <button type="submit" class="search-btn">search</button>
                </form>
                <a href="#"><img src="img/user.png" alt=""></a>
                <a href="#"><img src="img/cart.png" alt=""></a>
            </div>
        </div>`;
}

createNav();
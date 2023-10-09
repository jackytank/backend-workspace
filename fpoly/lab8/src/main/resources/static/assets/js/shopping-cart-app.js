var app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function ($scope, $http) {
    $scope.cart = {
        items: [],
        add(id) {
            let item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(res => {
                    res.data.qty = 1;
                    this.items.push(res.data);
                    this.saveToLocalStorage();
                });
            }
        },
        remove(id) {
            let index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        clear() {
            this.items = [];
            this.saveToLocalStorage();
        },
        ammount_of(item) {
        },
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0);
        },
        saveToLocalStorage() {
            let json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem('cart', json);

        },
        loadFromLocalStorage() {
            let json = localStorage.getItem('cart');
            this.items = json ? JSON.parse(json) : [];
        }
    };
    $scope.cart.loadFromLocalStorage();

    $scope.order = {
        createDate: new Date(),
        address: "",
        account: {username: document.getElementById("login-username").innerText},
        get orderDetails() {
            return $scope.cart.items.map(item => {
                return {
                    product: {id: item.id},
                    price: item.price,
                    quantity: item.qty,
                }
            })
        },
        purchase() {
            let order = angular.copy(this)
            console.log(order)
            $http.post('/rest/orders', order).then(res => {
                alert("Order successfully created")
                $scope.cart.clear();
                location.href = "/order/detail/" + res.data.id
            }).catch(err => {
                alert("Error creating order!")
                console.log(err);
            })
        }
    }
});
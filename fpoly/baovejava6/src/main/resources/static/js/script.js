
const app = angular.module("myapp", []);
app.controller("myctrl", function ($scope, $http) {
    $scope.form = {};
    $scope.items = {};
    $scope.reset = function () {
        $scope.form = {};
        $scope.key = null;
    };

    $scope.getAuthorities = function (userId) {
        $http.get(`/rest/authorities/users/${userId}`).then(res => {
            // res.data.forEach(el => {
            //     console.log(el.role.id);
            // });
            return res.data.role.id;
        });
    };


    $scope.load_all = function () {
        const url = `/rest/users`;
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(el => {
                el.role = [];
                el.role = $scope.getAuthorities(el.id);
            });
            console.log("Load all success!", resp);
        }).catch(err => console.log(err));
    };
    $scope.edit = function (key) {
        const url = `/rest/users/${key}`;
        $http.get(url).then(resp => {
            $scope.form = resp.data;
            $scope.key = key;
            console.log("Edit success!", resp);
        }).catch(err => console.log(err));
    };
    $scope.create = function () {
        const item = angular.copy($scope.form);
        const url = `/rest/users?role=${item.role}`;
        $http.post(url, item).then(resp => {
            $scope.items.push(item);
            $scope.reset();
            console.log("Create success!", resp);
        }).catch(err => console.log(err));


    };
    $scope.update = function () {
        const item = angular.copy($scope.form);
        const url = `/rest/users/${item.id}`;
        $http.put(url, item).then(resp => {
            $scope.items[$scope.key] = resp.data;
            $scope.load_all();
            console.log("Update success!", resp);
        }).catch(err => console.log(err));

    };
    $scope.delete = function (key) {
        const url = `/rest/users/${$scope.key}`;
        $http.delete(url).then(resp => {
            delete $scope.items[key];
            $scope.reset();
            $scope.load_all();
            console.log("Delete success!", resp);
        }).catch(err => console.log(err));
    };

    $scope.search = function (query) {
        $http.get(`/rest/users?query=${query.replace(/ /g, '')}`).then(resp => {
            $scope.items = resp.data;
        });
    };
    $scope.load_all();
    $scope.reset();
});
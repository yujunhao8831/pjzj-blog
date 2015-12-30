
define(["angular"],function (angular) { // 这里的定义一个独立的模块

    console.log(angular);

    return angular.module("user",[]).service("userService",["$http",function ($http) {
        this.user = function () {
            console.log("user");
        }
        return this;
    }]);
});

//define(function () {
//
//    console.log('angular');
//    var GET = "GET";
//    var DELETE = "DELETE";
//    var PUT = "PUT";
//    var POST = "POST";
//
//    //return {
//    //    user : function () {
//    //        console.log(22);
//    //        //$http({
//    //        //    url : "user",
//    //        //    method : GET,
//    //        //    params : {
//    //        //
//    //        //    }
//    //        //}).success(function (model) {
//    //        //    console.log(model);
//    //        //}).error(function () {
//    //        //
//    //        //});
//    //    }
//    //}
//});

/*
    $http({
        url : "user",
        method : GET,
        params : {

        }
    }).success(function (model) {
        console.log(model);
    }).error(function () {

    });
*/
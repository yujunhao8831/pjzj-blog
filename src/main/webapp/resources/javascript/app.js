require.config({
    baseUrl : "resources/framework",
    paths : {
        "jquery" : "jquery/jquery",
        "bootstrap" : "bootstrap/js/bootstrap.min",
        "angular" : "angular/angular.min",
        "angular-ui-router" : "angular/angular-ui-router",
    },
    shim : {
        "angular" : {
            exports : 'angular'
        },
        "angular-ui-router" : {
            deps : ['angular'],
            exports : 'angular-ui-router'
        }
    }
});

require(["jquery","angular","angular-ui-router"],function (jquery,angular) {
    var app = angular.module("app",["ui.router"]);

    app.config(["$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider) {

    }]);


    // 加载
    angular.element().ready(function() {
        angular.bootstrap(document, ['app']);
    });
});
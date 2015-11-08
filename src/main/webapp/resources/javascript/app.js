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
        $urlRouterProvider.otherwise("/index");
        $stateProvider.state("/index",{ // 当浏览器地址栏中是 "/" 时,应用会转换到index状态,然后使用templateUrl对应的模板内容去填充ui-view
            url     : "",
            views   : {
                "" : {},
                "top@/index" : {
                    templateUrl : "top"
                },
                "main@/index" : {
                    templateUrl : "main"
                },
                "bottom@/index" : {
                    templateUrl : "bottom"
                }
            }
        })
    }]);


    // 加载
    angular.element().ready(function() {
        angular.bootstrap(document, ['app']);
    });
});
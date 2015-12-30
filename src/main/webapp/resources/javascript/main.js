require.config({
    baseUrl : "resources",
    paths : {
        "jquery" : "framework/jquery/jquery",
        "bootstrap" : "framework/bootstrap/js/bootstrap.min",
        "angular" : "framework/angular/angular.min",
        "angular-ui-router" : "framework/angular/angular-ui-router",
        "angular-resource" : "framework/angular/angular-resource.min",
    },
    shim : {
        "angular" : {
            exports : 'angular'
        }, "angular-ui-router" : {
            deps : ['angular'],
            exports : 'angular-ui-router'
        }, "angular-resource" : {
            deps : ['angular'],
            exports : 'angular-resource'
        }
    }
});

require([
        "javascript/app",
        "javascript/service/user/userService",
        ],
    function (app,userService) {

        console.log(userService);
        console.log(userService.user());

        app.config(["$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/index");
            $stateProvider.state("/index",{ // 当浏览器地址栏中是 "/" 时,应用会转换到index状态,然后使用templateUrl对应的模板内容去填充ui-view
                url     : "",
                views   : {
                    "" : {},
                    "top@/index" : {
                        templateUrl : "top",
                        //controller : "userService"
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
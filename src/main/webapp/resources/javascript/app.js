define([
    'angular',
    // "bootstrap",
    "jquery",
    "angular-ui-router",
    "angular-resource",
    "angular-resource",
    "javascript/service/user/userService",
], function (angular) {
    // 创建一个模块 app
    return angular.module('app', ["ui.router","ngResource"]);
});

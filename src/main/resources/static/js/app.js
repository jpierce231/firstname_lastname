/**
 * Created by jpierce on 9/3/16.
 */
'use strict';

angular.module('simplecrud', ['ui.router', 'ngResource'])
    .config(function ($stateProvider, $urlRouterProvider, $locationProvider) {

        // Use HTML5 Mode (get rid of the hashtags)
        $locationProvider.html5Mode(true);

        // Set routes
        $stateProvider
            .state('users', {
                abstract: true,
                url: '/',
                template: '<ui-view />'
            })
            .state('users.list', {
                url: '',
                parent: 'users',
                templateUrl: '/views/users.html',
                controller: 'UsersCtrl',
                controllerAs: 'users'
            })
            .state('users.create', {
                url: 'create',
                parent: 'users',
                templateUrl: '/views/createUser.html',
                controller: 'CreateUserCtrl',
                controllerAs: 'createUser'
            })
            .state('users.update', {
                url: 'update/{:userId}',
                parent: 'users',
                templateUrl: '/views/updateUser.html',
                controller: 'UpdateUserCtrl',
                controllerAs: 'updateUser'
            });

        // Redirect to '/' if not one of the routes above
        $urlRouterProvider.otherwise('/');
    });

/**
 * Created by jpierce on 9/4/16.
 */
'use strict';

angular.module('simplecrud')
    .factory('UserService', ['$resource', function($resource) {
        var data = $resource('http://localhost:8080/api/v1/users/:id', {id: '@id'}, {
            update: {
                method: 'PUT'
            }
        });
        return data;
    }]);

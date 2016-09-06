'use strict';

angular.module('simplecrud')
    .controller('UsersCtrl', ['$scope', '$resource', 'UserService',
        function($scope, $resource, UserService) {

        var vm = this;
        vm.users = [];
        vm.user = {};

        vm.users = UserService.query(function(result) {
            vm.users = result;
        });

        vm.deleteUser = function(user, index) {
            UserService.delete({id:user.id});
            vm.users.splice(index, 1);
        }
    }]);
'use strict';

angular.module('simplecrud')
    .controller('CreateUserCtrl', ['$scope', '$state', '$resource', 'UserService',
        function($scope, $state, $resource, UserService) {

        var vm = this;
        vm.user = {};

        vm.saveUser =  function() {
            UserService.save(vm.user).$promise.then(function() {
                $state.go('users.list');
            });
        }
    }]);
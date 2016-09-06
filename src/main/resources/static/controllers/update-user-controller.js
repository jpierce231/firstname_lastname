'use strict';

angular.module('simplecrud')
    .controller('UpdateUserCtrl', ['$scope', '$state', '$stateParams', '$resource', 'UserService',
        function($scope, $state, $stateParams, $resource, UserService) {

        console.log($stateParams.userId);

        var vm = this;
        vm.user = {};

        vm.user = UserService.get({id:$stateParams.userId}).$promise.then(function(result) {
            vm.user = result;
        });

        vm.updateUser = function() {
            UserService.update(vm.user).$promise.then(function() {
                $state.go('users.list');
            });
        }
    }]);
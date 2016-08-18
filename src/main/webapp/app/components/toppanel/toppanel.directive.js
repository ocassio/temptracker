(function () {

    'use strict';

    angular
        .module('temptracker')
        .directive('xxTopPanel', xxTopPanel);

    function xxTopPanel($window) {
        'ngInject';

        return {
            restrict: 'E',
            templateUrl: 'toppanel.html',
            link: function (scope) {
                scope.username = $window.username;
            }
        }
    }

})();
(function () {

    'use strict';

    angular
        .module('temptracker')
        .directive('xxTopPanel', xxTopPanel);

    function xxTopPanel() {
        return {
            restrict: 'E',
            templateUrl: 'toppanel.html'
        }
    }

})();
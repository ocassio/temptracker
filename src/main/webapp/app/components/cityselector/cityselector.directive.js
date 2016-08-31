(function () {

    'use strict';

    angular
        .module('temptracker')
        .directive('xxCitySelector', xxCitySelector);

    function xxCitySelector() {
        return {
            restrict: 'E',
            controller: 'CitySelectorController',
            controllerAs: 'citySelector',
            templateUrl: 'cityselector.html',
            scope: {
                value: '='
            }
        }
    }

})();
(function () {

    'use strict';

    angular
        .module('temptracker')
        .controller('CitySelectorController', CitySelectorController);

    function CitySelectorController($scope, citiesService) {
        'ngInject';

        var vm = this;
        vm.cities = [];

        init();

        function init() {
            citiesService.getCities().success(onCitiesLoaded);
        }

        function onCitiesLoaded(response) {
            vm.cities = response;
            if (!$scope.value && vm.cities.length > 0) {
                $scope.value = vm.cities[0];
            }
        }
    }

})();
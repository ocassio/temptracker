(function () {

    'use strict';

    angular
        .module('temptracker')
        .factory('citiesService', citiesService);

    function citiesService($http) {
        'ngInject';

        return {
            getCities: getCities
        };

        function getCities() {
            return $http.get('api/cities');
        }
    }

})();
(function () {

    'use strict';

    angular
        .module('temptracker')
        .directive('xxRecordsList', xxRecordsList);

    function xxRecordsList() {
        return {
            restrict: 'E',
            controller: 'RecordsListController',
            controllerAs: 'recordsList',
            templateUrl: 'recordslist.html',
            scope: {
                city: '='
            }
        }
    }

})();
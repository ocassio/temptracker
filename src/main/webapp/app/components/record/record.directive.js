(function () {

    'use strict';

    angular
        .module('temptracker')
        .directive('xxRecord', xxRecord);

    function xxRecord() {
        return {
            restrict: 'E',
            templateUrl: 'record.html',
            scope: {
                record: '=',
                delete: '&'
            }
        }
    }

})();
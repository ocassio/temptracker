(function () {

    'use strict';

    angular
        .module('temptracker')
        .factory('recordsService', recordsService);

    function recordsService($http, DATE_FORMAT) {
        'ngInject';

        return {
            getRecord: getRecord,
            getRecords: getRecords,
            addOrUpdateRecord: addOrUpdateRecord,
            deleteRecord: deleteRecord
        };

        function getRecord(recordId) {
            return $http.get('api/records/' + recordId);
        }

        function getRecords(cityId) {
            var params = {
                city: cityId
            };
            return $http.get('api/records', {params: params});
        }

        function addOrUpdateRecord(record) {
            return $http.post('api/records/addOrUpdate', record);
        }

        function deleteRecord(recordId) {
            var params = {
                id: recordId
            };
            return $http.delete('api/records/delete', {params: params});
        }

    }

})();
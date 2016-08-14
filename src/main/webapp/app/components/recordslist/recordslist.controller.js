(function () {

    'use strict';

    angular
        .module('temptracker')
        .controller('RecordsListController', RecordsListController);

    function RecordsListController($scope, recordsService, DATE_FORMAT) {
        'ngInject';

        var vm = this;
        vm.records = [];
        vm.getDate = getDate;
        vm.onRecordDelete = onRecordDelete;

        loadRecords($scope.city);

        $scope.$watch('city', loadRecords);

        function loadRecords(city) {
            var cityId = city ? city.id : null;
            recordsService.getRecords(cityId).success(onRecordsLoaded);
        }

        function onRecordsLoaded(response) {
            vm.records = response;
        }

        function getDate(record) {
            return moment(record.date, DATE_FORMAT).toDate();
        }

        function onRecordDelete(recordId) {
            recordsService.deleteRecord(recordId).success(onRecordDeleted);
        }

        function onRecordDeleted() {
            loadRecords($scope.city);
        }
    }

})();
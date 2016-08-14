(function () {

    'use strict';

    angular
        .module('temptracker')
        .controller('RecordPageController', RecordPageController);

    function RecordPageController($state, $stateParams, recordsService, DATE_FORMAT) {
        'ngInject';

        var vm = this;
        vm.record = {};
        vm.cities = [];
        vm.submit = submit;

        init();

        function submit() {
            vm.error = null;
            var data = angular.copy(vm.record);
            data.date = moment(data.date).format(DATE_FORMAT);
            recordsService.addOrUpdateRecord(data).success(onSubmitted);
        }

        function onSubmitted(response) {
            if (!response.error) {
                $state.go('records');
            } else {
                vm.error = response.error;
            }
        }

        function init() {
            if ($stateParams.id) {
                recordsService.getRecord($stateParams.id).success(onRecordLoaded);
            }
        }

        function onRecordLoaded(response) {
            var record = response;
            record.date = moment(record.date, DATE_FORMAT).toDate();
            vm.record = record;
        }
    }

})();
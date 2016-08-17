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
        vm.disableButton = false;
        vm.submit = submit;

        init();

        function submit() {
            vm.disableButton = true;
            vm.error = null;
            recordsService.addOrUpdateRecord(vm.record).success(onSubmitted);
        }

        function onSubmitted(response) {
            if (!response.error) {
                $state.go('records');
            } else {
                vm.error = response.error;
            }
            vm.disableButton = false;
        }

        function init() {
            if ($stateParams.id) {
                recordsService.getRecord($stateParams.id).success(onRecordLoaded);
            }
        }

        function onRecordLoaded(response) {
            vm.record = response;
        }
    }

})();
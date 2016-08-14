(function () {

    'use strict';

    angular
        .module('temptracker')
        .controller('RecordsPageController', RecordsPageController);

    function RecordsPageController() {
        var vm = this;
        vm.city = null;
    }

})();
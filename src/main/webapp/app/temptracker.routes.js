(function () {

    'use strict';

    angular
        .module('temptracker')
        .config(routes);
    
    function routes($stateProvider, $urlRouterProvider) {
        'ngInject';

        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('records', {
                url: '/',
                controller: 'RecordsPageController',
                controllerAs: 'recordsPage',
                templateUrl: 'layouts/recordspage/recordspage.html'
            })
            .state('add', {
                url: '/add',
                controller: 'RecordPageController',
                controllerAs: 'recordPage',
                templateUrl: 'layouts/recordpage/recordpage.html'
            })
            .state('edit', {
                url: '/edit/:id',
                controller: 'RecordPageController',
                controllerAs: 'recordPage',
                templateUrl: 'layouts/recordpage/recordpage.html'
            });
    }

})();
var app = angular.module('controleContas',['ui.router','ngStorage', 'chart.js']);
 
app.constant('urls', {
    BASE: 'http://localhost:8080/ControleConta',
    CONTAS_SERVICE_API : 'http://localhost:8080/ControleConta/api/conta/'
});
 
app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'ContaController',
                controllerAs:'ctrl',
                resolve: {
                    contas: function ($q, ContaService) {
                        console.log('Carrega Contas');
                        var deferred = $q.defer();
                        ContaService.loadAllContas().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);
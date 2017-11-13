'use strict';
 
angular.module('controleContas').factory('ContaService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
 
            var factory = {
                loadAllContas: loadAllContas,
                getAllContas: getAllContas,
                createConta: createConta,
                removeConta: removeConta
            };
 
            return factory;
 
            function loadAllContas() {
                console.log('Fetching all Contas');
                var deferred = $q.defer();
                $http.get(urls.CONTAS_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all Contas');
                            $localStorage.contas = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function getAllContas(){
                return $localStorage.contas;
            }
 
 
            function createConta(conta) {
                var deferred = $q.defer();
                $http.post(urls.CONTAS_SERVICE_API, conta)
                    .then(
                        function (response) {
                        	loadAllContas();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error ao criar lançamento : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function removeConta(id) {
                var deferred = $q.defer();
                $http.delete(urls.CONTAS_SERVICE_API + id)
                    .then(
                        function (response) {
                        	loadAllContas();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Erro ao remover registro:'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
        }
    ]);
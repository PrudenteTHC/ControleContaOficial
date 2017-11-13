'use strict';
 
angular.module('controleContas').controller('ContaController',
    ['ContaService', '$scope',  function( ContaService, $scope) {
    	
        var self = this;
        self.conta = {};
        self.contas =[];
 
        self.submit = submit;
        self.getAllContas = getAllContas;
        self.createConta = createConta;
        self.removeConta = removeConta;
        self.reset = reset;
 
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
 
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
        
        $scope.labels = ["Receitas", "Despesas"];

        
        var test = ContaService.getAllContas();
        var vReceitas = 0;
        var vDespesas = 0;
        for(var i = 0; i < test.length; i++){
        	if(test[i].tipo){
        		vReceitas += test[i].valor;
        	} else {
        		vDespesas += test[i].valor;
        	}
        }
        $scope.data = [vReceitas,vDespesas];
        
        function defineDataChart(){
        	 var test = ContaService.getAllContas();
             var vReceitas = 0;
             var vDespesas = 0;
             for(var i = 0; i < test.length; i++){
             	if(test[i].tipo){
             		vReceitas += test[i].valor;
             	} else {
             		vDespesas += test[i].valor;
             	}
             }
             $scope.data = [vReceitas,vDespesas];
        }
        
        $scope.isVisible = false;
        $scope.showHide = function () {
            $scope.isVisible = $scope.isVisible ? false : true;
        }
        $scope.getClass = function(tipo) {
            if (tipo) {
                return 'receita';
            } else {
            	return 'despesa';
            }
        }
        
        function submit() {
            console.log('Submitting');
            if (self.conta.id === undefined || self.conta.id === null) {
                createConta(self.conta);
            } 
        }
 
        function createConta(conta) {
            ContaService.createConta(conta)
                .then(
                    function (response) {
                        self.successMessage = 'Registro lançado com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        self.conta={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        self.errorMessage = 'Erro ao lançar registro ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
 
 
 
        function removeConta(id){
            ContaService.removeConta(id)
                .then(
                    function(){
                    },
                    function(errResponse){
                        console.error('Erro ao remover um registro '+id +', Error :'+errResponse.data);
                    }
                );
        }
 
 
        function getAllContas(){
            return ContaService.getAllContas();
        }
        

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.conta={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]).filter("dateOnly", function(){
    	return function(input){
        	return input.split('T')[0];
        };
    }).filter('sumByColumn', function () {
        return function (collection, column, typeOf, scope) {
            var total = 0;

            collection.forEach(function (item) {
            	if(item["tipo"] == typeOf){
            		total += parseInt(item[column]);
            	}
            });
            
            return total;
          };
     });


//criacao de constrollers
appCliente.controller("clienteController", function ($scope, $http){
	//Variaveis
	//$scope.nome = "Joao";
	//$scope.sobreNome = "Da Silva";
	$scope.clientes = [];
	$scope.cliente={}; // o que setar aqui reflete na tela  -> bind com o model

	//Request alimenta a array clientes com o response da api rest
	//$scope.carregarClientes = function (){
	carregarClientes = function (){
		//token = localStorage.getItem("userToken");
		//$http.defaults.headers.common.Authorization = 'Bearer '+token;		
		//$http({method:'GET', url:'http://localhost:8080/admin/clientes'})
		$http({method:'GET', url:'http://localhost:8080/clientes'})
		.then(function(response){
			$scope.clientes = response.data;			
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarClientes = function (){		
		if ($scope.frmCliente.$valid){
			//$http({method:'POST', url:'http://localhost:8080/admin/clientes', data:$scope.cliente})
			$http({method:'POST', url:'http://localhost:8080/clientes', data:$scope.cliente})
			.then(function(response){
				console.log("Chamou a funcao salvar no cliente-controller.js");
				$scope.clientes.push (response.data);
				console.log(response.data);
				console.log(response.status);
				carregarClientes();
				//CHAMA PARA LIMPAR O CAMPO
				$scope.cancelarAlteracaoCliente()
				$scope.frmCliente.$setPristine(true);
			}, function (response){
				console.log(response.data);
				console.log(response.status);
			});
			
		}else{
			window.alert("Verifique o fomulário, dados incompletos ou Inválidos");
		}

	}
	
	$scope.excluirCliente = function (cliente) {
		//$http({method:'DELETE', url:'http://localhost:8080/admin/clientes/'+cliente.id})
		$http({method:'DELETE', url:'http://localhost:8080/clientes/'+cliente.id})
		.then(function(response){
			//Buscar posicao do cliente no array
			console.log("Chamou a funcao excluirCliente no cliente-controller.js");
			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice (pos,1); 

			
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	$scope.alterarCliente = function (cli) {
		$scope.cliente = angular.copy(cli);
		
	}
	
	$scope.cancelarAlteracaoCliente = function(){
		$scope.cliente = {};
	}
	
	
	carregarClientes();
	
	
	
});

appCliente.directive('cpfValido', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, elem, attrs, ctrl) {
 
            scope.$watch(attrs.ngModel, function () {
 
                if (elem[0].value.length == 0)
                    ctrl.$setValidity('cpfValido', true);
                else if (elem[0].value.length < 11) {
                    //aplicar o algoritmo de validação completo do CPF
                    ctrl.$setValidity('cpfValido', false);
                }
                else ctrl.$setValidity('cpfValido', true);
            });
        }
    };
});
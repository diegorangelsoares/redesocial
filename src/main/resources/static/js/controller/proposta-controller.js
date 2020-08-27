//criacao de constrollers
appCliente.controller("propostaController", function ($scope, $http){
	//Variaveis
	$scope.propostas = [];
	$scope.proposta={}; // o que setar aqui reflete na tela  -> bind com o model
	
	$scope.clientes = [];
	$scope.cliente={}; // o que setar aqui reflete na tela  -> bind com o model
	
	$scope.usuarios = [];
	$scope.usuario={}; // o que setar aqui reflete na tela  -> bind com o model
	
	//$rootScope.quantidadePropostas = 0;

	//Request alimenta a array proposta com o response da api rest
	//$scope.carregarPropostas = function (){
	carregarPropostas = function (){
		//token = localStorage.getItem("userToken");
		//$http.defaults.headers.common.Authorization = 'Bearer '+token;
		//$http({method:'GET', url:'/admin/Propostas'})
		$http({method:'GET', url:'/Propostas'})
		.then(function(response){
			$scope.propostas = response.data;
			//$scope.quantidadePropostas = $scope.usuario.count();
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
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
	
	carregarUsuarios = function (){
		//token = localStorage.getItem("userToken");
		//$http.defaults.headers.common.Authorization = 'Bearer '+token;
		//$http({method:'GET', url:'http://localhost:8080/admin/Usuarios'})
		$http({method:'GET', url:'http://localhost:8080/Usuarios'})
		.then(function(response){
			$scope.usuarios = response.data;
			
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarPropostas = function (){		
		if ($scope.frmProposta.$valid){
			//$http({method:'POST', url:'http://localhost:8080/admin/Propostas', data:$scope.proposta})
			$http({method:'POST', url:'http://localhost:8080/Propostas', data:$scope.proposta})
			.then(function(response){
				
				$scope.propostas.push (response.data);
				console.log(response.data);
				console.log(response.status);
				carregarPropostas();
				//CHAMA PARA LIMPAR O CAMPO
				$scope.cancelarAlteracaoProposta()
				$scope.frmProposta.$setPristine(true);
			}, function (response){
				console.log(response.data);
				console.log(response.status);
			});
			
		}else{
			window.alert("Faltando informações ou preenchimento Inválido");
		}

	}
	
	$scope.excluirProposta = function (proposta) {
		//$http({method:'DELETE', url:'http://localhost:8080/admin/Propostas/'+proposta.id})
		$http({method:'DELETE', url:'http://localhost:8080/Propostas/'+proposta.id})
		.then(function(response){
			//Buscar posicao da Proposta no array
			 
			pos = $scope.propostas.indexOf(proposta);
			$scope.propostas.splice (pos,1); 

			
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	$scope.alterarProposta = function (pro) {
		$scope.proposta = angular.copy(pro);
		
	}
	
	$scope.cancelarAlteracaoProposta = function(){
		$scope.proposta = {};
	}
	
	
	carregarPropostas();
	carregarClientes();
	carregarUsuarios();

	
});
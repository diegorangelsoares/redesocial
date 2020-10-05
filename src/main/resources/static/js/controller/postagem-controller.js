//criacao de constrollers
appCliente.controller("postagensController", function ($scope, $http){
	//Variaveis
	$scope.postagens = [];
	$scope.postagem={}; // o que setar aqui reflete na tela  -> bind com o model
	
	$scope.clientes = [];
	$scope.cliente={}; // o que setar aqui reflete na tela  -> bind com o model
	
	$scope.usuarios = [];
	$scope.usuario={}; // o que setar aqui reflete na tela  -> bind com o model
	
	//$rootScope.quantidadePostagens = 0;

	//Request alimenta a array Postagem com o response da api rest
	//$scope.carregarPostagens = function (){
	carregarPostagens = function (){
		$http({method:'GET', url:'/Postagens'})
		.then(function(response){
			$scope.postagem = response.data;
			//$scope.quantidadePostagens = $scope.usuario.count();
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	carregarPessoasUsuarios = function (){
		//token = localStorage.getItem("userToken");
		//$http.defaults.headers.common.Authorization = 'Bearer '+token;
		//$http({method:'GET', url:'http://localhost:8080/admin/clientes'})
		$http({method:'GET', url:'http://localhost:8080/PessoasUsuarios'})
		.then(function(response){
			$scope.clientes = response.data;
			
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	// carregarUsuarios = function (){
	// 	//token = localStorage.getItem("userToken");
	// 	//$http.defaults.headers.common.Authorization = 'Bearer '+token;
	// 	//$http({method:'GET', url:'http://localhost:8080/admin/Usuarios'})
	// 	$http({method:'GET', url:'http://localhost:8080/Postagens'})
	// 	.then(function(response){
	// 		$scope.usuarios = response.data;
	//
	// 		console.log(response.data);
	// 		console.log(response.status);
	// 	}, function (response){
	// 		console.log(response.data);
	// 		console.log(response.status);
	// 	});
	// };
	
	$scope.salvarPostagem = function (){
		console.log("Chamou o salvarPostagem");
		if ($scope.frmPostagem.$valid){
			$http({method:'POST', url:'http://localhost:8080/Postagens', data:$scope.postagem})
			.then(function(response){
				
				$scope.postagens.push (response.data);
				console.log(response.data);
				console.log(response.status);
				//carregarPropostas();
				//CHAMA PARA LIMPAR O CAMPO
				//$scope.cancelarAlteracaoProposta()
				$scope.frmPostagem.$setPristine(true);
			}, function (response){
				//console.log(response.data);
				console.log(response.status);
			});
			
		}else{
			window.alert("Faltando informações ou preenchimento Inválido");
		}

	}
	
	$scope.excluirProposta = function (proposta) {
		//$http({method:'DELETE', url:'http://localhost:8080/admin/Propostas/'+proposta.id})
		$http({method:'DELETE', url:'http://localhost:8080/Postagens/'+proposta.id})
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
	
	$scope.alterarPostagem = function (po) {
		$scope.postagem = angular.copy(po);
		
	}
	
	$scope.cancelarAlteracaoPostagem = function(){
		$scope.postagem = {};
	}
	
	
	carregarPostagens();
	//carregarClientes();
	//carregarUsuarios();

	
});
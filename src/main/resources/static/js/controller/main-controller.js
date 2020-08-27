appCliente.controller("mainController", function($scope, $route, $location, $routeParams, $http, $rootScope){
	
	$scope.$location = $location;
	$scope.$route=$route
	$scope.$routeParams=$routeParams;
	
	$scope.usuario={};
	$rootScope.usuarioLogado= null;	
	//$scope.token = "";
	
	$scope.mensagem= "";	
	
	$scope.quantidadePropostas =0;
	$scope.quantidadeUsuarios = 0;
	$scope.quantidadeClientes = 0;
	
	$scope.mensagemQuantidadePropostas ="";
	$scope.mensagemQuantidadeUsuarios = "";
	$scope.mensagemQuantidadeClientes = "";
	
	$scope.mensagemQuantidades= "";
	
	$scope.autenticar = function (){
		console.log("CHAMOU AUTENTICAR: "); 
		$http.post("http://localhost:8080/autenticar",$scope.usuario).then(function(response){ //http://localhost:8080/autenticar
			//console.log("Sucesso - "+response);
			//$scope.token = response.data.token;
			//localStorage.setItem("userToken", response.data.token);
			//$scope.usuarioLogado = response.data.usuario;
			console.log("Sucesso com o Usuario: "+response.data.usuario.nome);
			//$scope.usuarioLogado = response.data.usuario;
			$rootScope.usuarioLogado = response.data.usuario;
			$scope.mensagem = "Olá, "+$rootScope.usuarioLogado.nome;
			$scope.usuario = null;
			//$location.path('/home')
			/**
			if($scope.usuarioLogado == null){
	            $location.path('/acessoNegado');
	        }*/
		
		},function(response){
			console.log("Falha - "+response);
			$location.path('/acessoNegado');
			$rootScope.usuarioLogado = null;
			$scope.usuarioLogado = null;
			$scope.mensagem= "";
		});	
		
		//console.log("NOME: "+$scope.usuario.nome + " SENHA:"+$scope.usuario.senha);
		
	}
	
	carregarQuantidadePropostas = function (){
		$http({method:'GET', url:'/api/CountPropostas'})
		.then(function(response){
			$scope.quantidadePropostas = response.data;
			$scope.mensagemQuantidades = $scope.mensagemQuantidades + " Propostas Cadastradas: "+$scope.quantidadePropostas + "  -  ";
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
		
	};
	
	carregarQuantidadeClientes = function (){
		$http({method:'GET', url:'/api/CountClientes'})
		.then(function(response){
			$scope.quantidadeClientes = response.data;
			$scope.mensagemQuantidades = $scope.mensagemQuantidades + " Clientes Cadastrados: "+$scope.quantidadeClientes + "  -  ";
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
		
	};
	
	carregarQuantidadeUsuarios = function (){
		$http({method:'GET', url:'/api/CountUsuarios'})
		.then(function(response){
			$scope.quantidadeUsuarios = response.data;
			$scope.mensagemQuantidades = $scope.mensagemQuantidades + " Usuários Cadastrados: "+$scope.quantidadeUsuarios;
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
		
	};
	
	$scope.logout = function (){
		console.log("Chamou o logout. "); 
		$rootScope.usuarioLogado = null;
		$scope.usuario = null;
		$scope.mensagem= "";

	}
	
	
	carregarQuantidadePropostas();
	carregarQuantidadeClientes();
	carregarQuantidadeUsuarios();
	
	
});


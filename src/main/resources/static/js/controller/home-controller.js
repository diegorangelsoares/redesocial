//criacao de constrollers
appCliente.controller("homeController", function ($scope, $http){
	
	//Variaveis
	$scope.propostas = [];
	$scope.proposta={}; // o que setar aqui reflete na tela  -> bind com o model
	$scope.quantidadePropostas=0;	
	
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
	
	carregarPropostas();
	
	

	
});
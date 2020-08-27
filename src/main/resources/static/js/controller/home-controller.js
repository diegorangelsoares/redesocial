//criacao de constrollers
appCliente.controller("homeController", function ($scope, $http){
	
	//Variaveis
	$scope.propostas = [];
	$scope.proposta={}; // o que setar aqui reflete na tela  -> bind com o model
	$scope.quantidadePropostas=0;	
	
	carregarPropostas = function (){

		$http({method:'GET', url:'/Postagens'})
		.then(function(response){
			$scope.propostas = response.data;
			console.log(response.data);
			//console.log(response.status);
		}, function (response){
			console.log(response.data);
			//console.log(response.status);
		});
	};
	
	carregarPropostas();
	
	

	
});
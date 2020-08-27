appCliente.controller("propostaDetalheController", function($scope, $routeParams, $http){
	
	$scope.proposta={}
	$http.get("propostas/"+$routeParams.propostaId).then(function(response){
		$scope.proposta=response.data;
		
	},function(response){
		console.log(response);
		
	});
	
});
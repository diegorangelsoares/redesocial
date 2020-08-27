//criacao de constrollers
appCliente.controller("loginController", function ($scope, $http){
	
	$scope.usuario={};
	$scope.usuarioLogado="";	
	//$scope.token = "";
	
	$scope.autenticar = function (){
		console.log("CHAMOU AUTENTICAR: "); 
		$http.post("/autenticar",$scope.usuario).then(function(response){ //http://localhost:8080/autenticar
			console.log("Sucesso - "+response);
			//$scope.token = response.data.token;
			//localStorage.setItem("userToken", response.data.token);
			//$scope.usuarioLogado = response.data.usuario;
			$scope.usuarioLogado = response.data.usuario;
		},function(response){
			console.log("Falha - "+response);
			
		});	
		
		//console.log("NOME: "+$scope.usuario.nome + " SENHA:"+$scope.usuario.senha);
		
	}
	
	$scope.logout = function (){
		console.log("Chamou o logout. "); 
			console.log("Sucesso - ");
			$scope.usuarioLogado = null;

	}
	
	

	
});
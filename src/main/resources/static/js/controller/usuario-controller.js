//criacao de constrollers
appCliente.controller("usuarioController", function ($scope, $http){
	//Variaveis
	//$scope.nome = "Joao";
	//$scope.sobreNome = "Da Silva";
	$scope.usuarios = [];
	$scope.usuario={}; // o que setar aqui reflete na tela  -> bind com o model

	//Request alimenta a array clientes com o response da api rest
	//$scope.carregarClientes = function (){
	carregarUsuarios = function (){
		//token = localStorage.getItem("userToken");
		//$http.defaults.headers.common.Authorization = 'Bearer '+token;		
		//$http({method:'GET', url:'http://localhost:8080/admin/clientes'})
		$http({method:'GET', url:'http://localhost:8080/Usuarios'})
		.then(function(response){
			$scope.usuarios = response.data;			
			//console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.salvarUsuarios = function (){		
		if ($scope.frmUsuario.$valid){
			//$http({method:'POST', url:'http://localhost:8080/admin/clientes', data:$scope.cliente})
			$http({method:'POST', url:'http://localhost:8080/Usuarios', data:$scope.usuario})
			.then(function(response){
				console.log("Chamou a funcao salvar no usuario-controller.js");
				$scope.usuarios.push (response.data);
				console.log(response.data);
				console.log(response.status);
				carregarUsuarios();
				//CHAMA PARA LIMPAR O CAMPO
				$scope.cancelarAlteracaoUsuario()
				$scope.frmUsuario.$setPristine(true);
			}, function (response){
				console.log(response.data);
				console.log(response.status);
			});
			
		}else{
			window.alert("Verifique o fomulário, dados incompletos ou Inválidos");
		}

	}
	
	$scope.excluirUsuario = function (usuario) {
		//$http({method:'DELETE', url:'http://localhost:8080/admin/clientes/'+cliente.id})
		$http({method:'DELETE', url:'http://localhost:8080/Usuarios/'+usuario.id})
		.then(function(response){
			//Buscar posicao do usuario no array
			console.log("Chamou a funcao excluirUsuario no usuario-controller.js");
			pos = $scope.usuarios.indexOf(usuario);
			$scope.usuarios.splice (pos,1); 

			
			console.log(response.data);
			console.log(response.status);
		}, function (response){
			console.log(response.data);
			console.log(response.status);
		});
	}
	
	$scope.alterarUsuario = function (usu) {
		$scope.usuario = angular.copy(usu);
		
	}
	
	$scope.cancelarAlteracaoUsuario = function(){
		$scope.usuario = {};
	}
	
	
	carregarUsuarios();
	
	
	
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
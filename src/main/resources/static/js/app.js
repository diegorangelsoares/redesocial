'use strict';

//Criacao do modulo principal da aplicacao
var appCliente = angular.module("appCliente", ['ngRoute']);

appCliente.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/clientes', {
			templateUrl: 'view/cliente.html',
			controller : "clienteController"
		})
		.when('/propostas', {
			templateUrl: 'view/proposta.html',
			controller : "propostaController"
		})
		.when('/propostasAuditar', {
			templateUrl: 'view/proposta-auditar.html',
			controller : "propostaAuditarController"
		})
		.when('/clientes/:clienteId', {
			templateUrl: 'view/cliente-detalhe.html',
			controller : "clienteDetalheController"
		})
		.when('/acessoNegado', {
            templateUrl: 'view/acessoNegado.html',
            controller: 'acessoNegadoController'
        })
        .when('/usuarios', {
            templateUrl: 'view/usuario.html',
            controller: 'usuarioController'
        })
		.when('/logout', {
			//templateUrl: 'index.html',
			//controller : "mainController",
			redirectTo:'/'
		})
		.when('/home', {
			templateUrl: 'view/home.html',
            controller: 'homeController'
		})
		.otherwise({redirectTo:'/'});	
	
	// configure html5 to get links working on jsfiddle
	//$locationProvider.html5Mode(true);
	
}]);




/**
appCliente.config(function($httpProvider){
		
	$httpProvider.interceptors.push('tokenInterceptor');


	
});

*/
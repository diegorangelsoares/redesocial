//appCliente.factory("tokenInterceptor", function($q, $location){
	/**
	return {
		
		'request': function(config){
			
			config.headers.Authorization = 'Bearer ' + localStorage.getItem("userToken");
			return config;
		},
		
		'responseError': function(rejection) {
		    if (rejection.status == 500){
		    	//$location.path("/login");
		    	$location.path("/");
		    }  
			
	      return $q.reject(rejection);
	    }
	
	};
	*/
	
	
//});
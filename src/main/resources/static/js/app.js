var app=angular.module("MyCat",[]);
app.controller("CatController",function($scope,$http){
	$scope.produits=[];
	$http.get("produits/produits/0/")
	.success(function(data){
        $scope.produits = data;
        $scope.pages=new Array(data.totalPages);
    });

	$scope.motCle=null;
	$scope.pageCourante=0;
	$scope.charger=function(){
		$http.get("produits/produitsParMC?mc="+$scope.motCle+"&page="+$scope.pageCourante)
		 .success(function(data){
			 $scope.produits=data;
			 $scope.pages=new Array(data.totalPages);
		 });
	};
	
	$scope.gotoPage=function(p){
		$scope.pageCourante=p;
		$scope.charger();
	};
	
});
myApp.controller("newsController", function($scope,$http){

    // Variables
	$scope.all = { list:[], next:true, prev:false};
	$scope.add = false;
	$scope.page= 1;
    $scope.unPage = 1;
	$scope.loading = false;
    $scope.isDeleteOpen = false;
    $scope.idNews = '';
    $scope.news = {
        subject: '',
        content: ''
    };
    $scope.searchIn = '';

    // Functions
    $scope.getAll = function ($page){
        $scope.loading = true;
        $http.get('/api/news/all/'+$scope.unPage)
            .then(function successCallback(response){
                    $scope.loading = false;
                    $scope.all = response.data;
        			$scope.newsCount = response.data.length-1;
                    if($page) $scope.page = $page;
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
            });
    }
    $scope.next = function(){ $scope.unPage = $scope.unPage + 1; $scope.getAll($scope.unPage);}
    $scope.prev = function(){ $scope.unPage = $scope.unPage - 1; $scope.getAll($scope.unPage);}
    $scope.setAdd = function(){
        if(!$scope.add)
            $scope.news = {
                subject: '',
                content: ''
            };
        $scope.add = !$scope.add;
    }
    $scope.addNews = function() {
        $http.post('/api/news/add/',$scope.news )
            .then(function successCallback(){
                $scope.getAll();
                $scope.setAdd();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.updateNews = function($id,$news) {
        $http.put('/api/news/update/',{ id: $id, nationality: $news })
            .then(function successCallback(){
                $scope.getAll();
                $scope.setEdit();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.search = function() {
        if($scope.searchIn === "")
        {
            $scope.page = 1;
            $scope.unPage = 1;
            $scope.getAll(1);
        }
        else{
            $scope.loading = true;
            $http.get('/api/news/all/keyword/'+$scope.searchIn)
                .then(function successCallback(response){
                    console.log(response);
                        $scope.loading = false;
                        $scope.all = { list :response.data, next: false, prev:false};

                        $scope.newsCount = response.data.length-1;
                }, function errorCallback(response) {
                        console.log('Error....');
                        console.log(response);
                });  
        }
    }

    // Initialization
    $scope.getAll();

});
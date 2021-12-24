myApp.directive('input',function(){
    return {
      restrict: 'E',
      scope: {
        ngModel: '=',
        ngChange: '&',
        type: '@'
      },
      link: function (scope, element, attrs) {
        if(scope.type.toLowerCase()!='file'){
          return;
        }
        element.bind('change', function(){
          let files =  element[0].files;
          scope.ngModel = files;
          scope.$apply();
          scope.ngChange();
        });
      }
    }
    
})

myApp.controller("actorController", function($scope,$http){

    // Variables
	$scope.all = { list:[], next:true, prev:false};
	$scope.add = false;
	$scope.edit = false;
	$scope.page= 1;
    $scope.unPage = 1;
	$scope.loading = false;
    $scope.isDeleteOpen = false;
    $scope.idActor = '';
    $scope.actor =  {
        fullNameActor:'',
        birthdayActor:'',
        nationalityActor: {},
        imgActor: ''
    };
    $scope.nationalities = [];
    $scope.searchIn = '';
    $scope.picture = [];

    // Functions
    $scope.getActors = function ($page){
        $scope.loading = true;
        $http.get('/api/actor/all/'+$scope.unPage)
            .then(function successCallback(response){
                    $scope.loading = false;
                    $scope.all = response.data;
                    if($page) $scope.page = $page;
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
            });
    }
    $scope.getNationalities = function (){
        $http.get('/api/nationality/all')
            .then(function successCallback(response){
                    $scope.nationalities = response.data;
                    $scope.actor.nationalityAction = $scope.nationalities[0];
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
            });
    }
    $scope.next = function(){ $scope.unPage = $scope.unPage + 1; $scope.getActors($scope.unPage);}
    $scope.prev = function(){ $scope.unPage = $scope.unPage - 1; $scope.getActors($scope.unPage);}
    $scope.setAdd = function(){
        if($scope.edit)
            $scope.edit = false;
        if(!$scope.add){
            $scope.actor = {
                fullnameActor:'',
                birthdayActor:'',
                nationalityActor: $scope.nationalities[0],
                imgActor: ''
            };
            $scope.picture = [];
        }
        $scope.add = !$scope.add;
    }
    $scope.setEdit = function(){
        if($scope.add)
            $scope.add = false;
         $scope.edit = !$scope.edit;}
    $scope.addActor = function() {
        $http.post('/api/actor/add/', $scope.actor )
            .then(function successCallback(){
                $scope.getActors();
                $scope.setAdd();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.updateActor = function($id,$actor) {
        $http.put('/api/actor/update/', $scope.actor )
            .then(function successCallback(){
                $scope.getActors();
                $scope.setEdit();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.prerareUpdate = function($id) {
        $scope.actor=$scope.all.list.filter(ac=>ac.id ===$id)[0];
        if($scope.actor.birthdayActor)
            $scope.actor.birthdayActor= new Date ($scope.actor.birthdayActor);
        if($scope.add)
            $scope.add = false;
        $scope.edit = true;
    }
    $scope.prepareDelete = function($idActor){
        $scope.isDeleteOpen = true;
        $scope.idActor = $idActor;
    }
    $scope.deleteActor = function($idActor){
        $http.delete('/api/actor/delete/'+$idActor)
            .then(function successCallback(){
                $scope.getActors();
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
            $scope.getActors(1);
        }
        else{
            $scope.loading = true;
            $http.get('/api/actor/all/keyword/'+$scope.searchIn)
                .then(function successCallback(response){
                    console.log(response);
                        $scope.loading = false;
                        $scope.all = { list :response.data, next: false, prev:false};
                }, function errorCallback(response) {
                        console.log('Error....');
                        console.log(response);
                });  
        }
    }
    $scope.fileuploads = function(event){
        console.log("fewfew");
        const files = event.target.files;
        this.filesGallerie = files;
        console.log(files);
        console.log(event);
        if(files){
          for(let i=0; i< files.length;i++){
            this.allfiles.push(files[i]);
            const readerfiles = new FileReader();
            readerfiles.onload=(filedata)=>{
              this.image = readerfiles.result + '';
              this.images.push(this.image);
            };
            readerfiles.readAsDataURL(files[i]);
          }
        }
      }

    $scope.addPhoto = function() {  

        var url = "/api/upload/add";


        var data = new FormData();

        data.append("description", "actor");
        console.log($scope.actor.imgActor);
        for (i = 0; i < $scope.actor.imgActor.length; i++) {
            data.append("files", $scope.actor.imgActor[i]);
        }

        var config = {
            transformRequest: angular.identity,
            transformResponse: angular.identity,
            headers: {
                'Content-Type': undefined
            }
        }
       

       $http.post(url, data, config).then(
            // Success
            function(response) {
                $scope.actor.imgActor =  response.data;
                if($scope.add) $scope.addActor();
                else $scope.updateActor();
            },
            // Error
            function(response) {
                console.log(response.data);
            });
    };
      

    // Initialization
    $scope.getNationalities();
    $scope.getActors();

});
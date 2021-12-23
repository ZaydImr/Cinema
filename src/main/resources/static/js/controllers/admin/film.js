myApp.controller("filmController", function ($scope, $http) {

  // Variables
  $scope.all = { list: [], next: true, prev: false };
  $scope.addFilm = false;
  $scope.editFilm = false;
  $scope.page = 1;
  $scope.unPage = 1;
  $scope.loading = false;
  $scope.isDeleteOpen = false;
  $scope.idFilm = "";
  $scope.film = {
    titleFilm: "",
    descriptionFilm: "",
    dateRelease: "",
    durationFilm: "",
    filmType: {},
    nationality: {},
    director: {},
  };
  $scope.searchIn = "";

  // Functions
  $scope.getFilms = function ($page) {
    $scope.loading = true;
    $http.get("/api/film/all/" + $scope.unPage).then(
      function successCallback(response) {
        $scope.loading = false;
        $scope.all = response.data;
        $scope.filmsCount = response.data.length - 1;
        if ($page) $scope.page = $page;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getNationalities = function () {
    $http.get("/api/nationality/all").then(
      function successCallback(response) {
        $scope.nationalities = response.data;
        $scope.film.nationality = $scope.nationalities[0];
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getTypeFilm = function () {
    $http.get("/api/filmtypes/all").then(
      function successCallback(response) {
        $scope.typeFilms = response.data;
        $scope.film.typeFilms = $scope.typeFilms[0];
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getDirectors = function () {
    $http.get("/api/director/all").then(
      function successCallback(response) {
        $scope.directors = response.data;
        $scope.film.director = $scope.directors[0];
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.next = function () {
    $scope.unPage = $scope.unPage + 1;
    $scope.getFilms($scope.unPage);
  };
  $scope.prev = function () {
    $scope.unPage = $scope.unPage - 1;
    $scope.getFilms($scope.unPage);
  };
  $scope.setAdd = function () {
    if ($scope.editFilm) $scope.editFilm = false;
    if (!$scope.addFilm) {
      $scope.film = {
        titleFilm: "",
        descriptionFilm: "",
        dateRelease: "",
        durationFilm: "",
        filmType: $scope.typeFilms[0],
        director: $scope.directors[0],
        nationality: $scope.nationalities[0],
      };
    }

    $scope.addFilm = !$scope.addFilm;
  };

  $scope.setEdit = function () {
    if ($scope.addFilm) $scope.addFilm = false;
    $scope.editFilm = !$scope.editFilm;
  };
  $scope.addFilms = function ($film) {
    $http.post("/api/film/add/", $scope.film).then(
      function successCallback() {
        $scope.getFilms();
        $scope.setAdd();
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };
  $scope.updateFilm = function () {
    $http.put("/api/film/update/", $scope.film).then(
      function successCallback() {
        $scope.getFilms();
        $scope.setEdit();
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };
  $scope.prepareUpdate = function (idFilm) {
    $scope.film = $scope.all.list.filter(film=>film.id===idFilm)[0];

    if($scope.film.dateRelease)
      $scope.film.dateRelease = new Date($scope.film.dateRelease);
    if($scope.film.durationFilm)
      $scope.film.durationFilm = new Date($scope.film.durationFilm);
    

    if ($scope.addFilm) $scope.addFilm = false;
    $scope.editFilm = true;
  };
  $scope.prepareDelete = function (idFilm) {
    $scope.isDeleteOpen = true;
    $scope.idFilm = idFilm;
    console.log(idFilm);
  };
  $scope.deleteFilm = function () {
    $http.delete("/api/film/delete/"+ $scope.idFilm).then(
      function successCallback() {
        $scope.getFilms();
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };
  $scope.search = function () {
    if ($scope.searchIn === "") {
      $scope.page = 1;
      $scope.unPage = 1;
      $scope.getNat(1);
    } else {
      $scope.loading = true;
      $http.get("/api/film/all/keyword/" + $scope.searchIn).then(
        function successCallback(response) {
          console.log(response);
          $scope.loading = false;
          $scope.all = { list: response.data, next: false, prev: false };

          $scope.filmsCount = response.data.length - 1;
        },
        function errorCallback(response) {
          console.log("Error....");
          console.log(response);
        }
      );
    }
  };

  // Initialization
  $scope.getTypeFilm();
  $scope.getDirectors();
  $scope.getNationalities();
  $scope.getFilms();
});

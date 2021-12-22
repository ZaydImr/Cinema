myApp.controller("eventController", function ($scope, $http) {
  $scope.all = { list: [], next: true, prev: false };
  $scope.addEvent = false;
  $scope.editEvent = false;
  $scope.page = 1;
  $scope.unPage = 1;
  $scope.loading = false;
  $scope.isDeleteOpen = false;
  $scope.idEvent = "";
  $scope.event = {
    dateEvent: "",
    dateEndEvent: "",
    titleEvent: "",
    descriptionEvent: "",
    film: {},
  };
  $scope.searchIn = "";
  $scope.getEvent = function ($page) {
    $scope.loading = true;
    $http.get("/api/events/all/" + $scope.unPage).then(
      function successCallback(response) {
        $scope.loading = false;
        $scope.all = response.data;
        $scope.eventsCount = response.data.length - 1;
        if ($page) $scope.page = $page;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getFilms = function () {
    $http.get("/api/film/all").then(
      function successCallback(response) {
        $scope.films = response.data;
        $scope.event.film = $scope.films[0];
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.next = function () {
    $scope.unPage = $scope.unPage + 1;
    $scope.getEvent($scope.unPage);
  };
  $scope.prev = function () {
    $scope.unPage = $scope.unPage - 1;
    $scope.getEvent($scope.unPage);
  };
  $scope.setAdd = function () {
    if ($scope.editEvent) $scope.editEvent = false;
    if (!$scope.addEvent) {
      $scope.event = {
        dateEvent: "",
        dateEndEvent: "",
        imgEvent: "",
        titleEvent: "",
        descriptionEvent: "",
        film: {},
      };
    }
    $scope.addEvent = !$scope.addEvent;
  };
  $scope.setEdit = function () {
    if ($scope.addEvent) $scope.addEvent = false;
    $scope.editEvent = !$scope.editEvent;
  };
  $scope.addEvents = function () {
    $http.post("/api/events/add/", $scope.event).then(
      function successCallback() {
        $scope.getEvent();
        $scope.setAdd();
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };
  $scope.updateEvent = function () {
    $http.put("/api/events/update/", $scope.event).then(
      function successCallback() {
        $scope.getEvent();
        $scope.setEdit();
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };
  $scope.prepareUpdate = function () {
    if ($scope.addEvent) $scope.addEvent = false;
    $scope.editEvent = true;
  };
  $scope.prepareDelete = function () {
    $scope.isDeleteOpen = true;
    $scope.idEvent = $idEvent;
  };
  $scope.deleteEvent = function ($idEvent) {
    $http.delete("/api/events/delete/" + $idEvent).then(
      function successCallback() {
        $scope.getEvent();
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
      $scope.getEvent(1);
    } else {
      $scope.loading = true;
      $http.get("/api/events/all/keyword/" + $scope.searchIn).then(
        function successCallback(response) {
          console.log(response);
          $scope.loading = false;
          $scope.all = { list: response.data, next: false, prev: false };

          $scope.eventsCount = response.data.length - 1;
        },
        function errorCallback(response) {
          console.log("Error....");
          console.log(response);
        }
      );
    }
  };
  $scope.getFilms();
  $scope.getEvent();
});

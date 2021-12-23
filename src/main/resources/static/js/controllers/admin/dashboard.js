Date.prototype.addDays = function (days) {
  var date = new Date(this.valueOf());
  date.setDate(date.getDate() + days);
  return date;
}

myApp.controller("dashboardController", function ($scope, $http) {

  let today = new Date();
  let month = [];

  for (let i = -29; i <= 0; i++) {
    month.push(today.addDays(i).getDate())
  }

  $scope.todayVisitors = 0;
  $scope.totalClients = 0;
  $scope.totalFilms = 0;
  $scope.subscribers = 0;
  $scope.monthVisitors = [];

  $scope.getFilmsCount = function () {
    $http.get("/api/film/count").then(
      function successCallback(response) {
        $scope.totalFilms = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getSubscribersCount = function () {
    $http.get("/api/subscription/count").then(
      function successCallback(response) {
        $scope.subscribers = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getUsersCount = function () {
    $http.get("/api/user/count").then(
      function successCallback(response) {
        $scope.totalClients = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getVisitorsPerDay = function () {
    $http.get("/api/visitors/today").then(
      function successCallback(response) {
        $scope.todayVisitors = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getVisitors = function () {
    $http.get("/api/visitors/month").then(
      function successCallback(response) {

        let list = [];
        for (let i = 29; i >= 0; i--){
          if(response.data[i] == null)
            list.push(0)
          else
            list.push(response.data[i])
        }
        $scope.monthVisitors = list;

        const lineConfig = {
          type: 'line',
          data: {
            labels: month,
            datasets: [
              {
                label: 'Visitors per day',
                backgroundColor: '#0694a2',
                borderColor: '#0694a2',
                data: $scope.monthVisitors,
                fill: false,
              }
            ],
          },
          options: {
            responsive: true,
            /**
             * Default legends are ugly and impossible to style.
             * See examples in charts.html to add your own legends
             *  */
            legend: {
              display: false,
            },
            tooltips: {
              mode: 'index',
              intersect: false,
            },
            hover: {
              mode: 'nearest',
              intersect: true,
            },
            scales: {
              x: {
                display: true,
                scaleLabel: {
                  display: true,
                  labelString: 'Month',
                },
              },
              y: {
                display: true,
                scaleLabel: {
                  display: true,
                  labelString: 'Value',
                },
              },
            },
          },
        }

        const lineCtx = document.getElementById('line');
        window.myLine = new Chart(lineCtx, lineConfig);

      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getFilmsCount()
  $scope.getSubscribersCount()
  $scope.getUsersCount()
  $scope.getVisitorsPerDay()
  $scope.getVisitors()

});
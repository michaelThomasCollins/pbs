angular.module('app.controllers', []).controller('ShipwreckListController', function($scope, $state, popupService, $window, Shipwreck) {
  $scope.shipwrecks = Shipwreck.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks

  $scope.deleteShipwreck = function(shipwreck) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Really delete this?')) {
      shipwreck.$delete(function() {
        $scope.shipwrecks = Shipwreck.query(); 
        $state.go('shipwrecks');
      });
    }
  };
}).controller('ReportViewController', function($scope, $stateParams, Report) {
  $scope.shipwreck = Report.get({ id: $stateParams.id }); //Get a single report.Issues a GET to /api/v1/shipwrecks/:id
}).controller('LoginController', function($scope, Report) {
    //TODO Write a method to verify users credentials
    $scope.verifyCredentials = function () {

        alert(Report.toString());
    };
}).controller('ShipwreckCreateController', function($scope, $state, $stateParams, Shipwreck) {
  $scope.shipwreck = new Shipwreck();  //create new shipwreck instance. Properties will be set via ng-model on UI

  $scope.addReport = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
    $scope.report.$save(function() {
      $state.go('ho'); // on success go back to the list i.e. shipwrecks state.
    });
  };
}).controller('ShipwreckEditController', function($scope, $state, $stateParams, Shipwreck) {
  $scope.updateShipwreck = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $scope.shipwreck.$update(function() {
      $state.go('shipwrecks'); // on success go back to the list i.e. shipwrecks state.
    });
  };

  $scope.loadShipwreck = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
    $scope.shipwreck = Shipwreck.get({ id: $stateParams.id });
  };

  $scope.loadShipwreck(); // Load a shipwreck which can be edited on UI
}).controller('ChooseReportTypeController', function($scope, $state, $stateParams, reportTypeService) {
    $scope.reportType = 'views/_no_action_form.html';

    $scope.chooseReport = function () {
        var x = document.getElementById("option");
        var choice = x.options[x.selectedIndex].text;
        if (choice == "No Action") {
            $state.go('newReport');
            reportTypeService.setReportType('views/_no_action_form.html');
        } else if (choice == "investigation") {

        } else if (choice == "intervention") {

        } else if (choice == "inMotion") {

        } else {
            alert("Please select an option");
        }
    };

    $scope.getReportType = function () {
        //TODO Write code that searches what report type was chosen by the user
        var answer = 'views/_no_action_form.html';
        return reportTypeService.getReportType();
    };

}).controller('ReportSearchController', function($scope, $state,$stateParams) {
    //TODO Write a method to verify users credentials
    $scope.enterPressed = function (e) {
        if (e.which == 13 || e.keyCode == 13) {
            $scope.searchReport();
        }
    };

    $scope.searchReport = function(){
// TODO Return data values
        $state.go('reports');
    };
});

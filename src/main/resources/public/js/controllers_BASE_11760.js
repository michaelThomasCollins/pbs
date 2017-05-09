angular.module('app.controllers', []).controller('ReportDeleteController', function($scope, $state, popupService, $window, Report) {
  $scope.deleteReport = function(report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
    if (popupService.showPopup('Really delete this?')) {
      report.$delete(function() {
        $state.go('home');
      });
    }
  };
}).controller('ReportViewController', function($scope, $stateParams, Report) {
  $scope.report = Report.get({ id: $stateParams.id }); //Get a single report.Issues a GET to /api/v1/reports/:id
}).controller('LoginController', function($scope, Report) {
    //TODO Write a method to verify users credentials
    $scope.verifyCredentials = function () {

        alert(Report.toString());
    };
}).controller('ReportCreateController', function($scope, $state, $stateParams, Report) {
  $scope.report = new Report();  //create new report instance. Properties will be set via ng-model on UI

  $scope.addReport = function() { //create a new report. Issues a POST to /api/v1/reports
    $scope.report.$save(function() {
      $state.go('home'); // on success go back to the home page
    });
  };
}).controller('ReportEditController', function($scope, $state, $stateParams, Report) {
  $scope.updateReport = function() { //Update the edited report. Issues a PUT to /api/v1/reports/:id
    $scope.report.$update(function() {
      $state.go('home'); // on success go back to home state.
    });
  };

  $scope.loadReport = function() { //Issues a GET request to /api/v1/reports/:id to get a report to update
    $scope.report = Report.get({ id: $stateParams.id });
  };

  $scope.loadReport(); // Load a report which can be edited on UI
}).controller('ChooseReportTypeController', function($scope, $state, $stateParams, reportTypeService) {
    $scope.reportType = 'views/_no_action_form.html';

    $scope.chooseReport = function () {
        //TODO Could improve this code here, see editShipwreck({id:shipwreck.id}) formatting
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
        //TODO Write code that holds the state of the report type (currently if refresh, then lose state) !$stateParams!
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
        //   $scope.shipwrecks = Shipwreck.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks
        $state.go('reports');
    };
});

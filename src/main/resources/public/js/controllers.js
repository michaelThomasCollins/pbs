angular.module('app.controllers', []).controller('ReportViewController', function ($scope, $state, $stateParams, popupService, $window,$filter,Report) {
    $scope.report = Report.get({id: $stateParams.id}); //Get a single report.Issues a GET to /api/v1/reports/:id

    $scope.deleteReport = function (report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
        if (popupService.showPopup('Really delete this?')) {
            report.$delete(function () {
                $state.go('reports');
            });
        }
    };

    $scope.verifyReport = function (report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
        if (popupService.showPopup('Are you sure?')) {
            report.isVerified = "Yes";
            $scope.report.$update(function () {
            });
        }
    };

    $scope.denyReport = function (report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
        if (popupService.showPopup('Are you sure?')) {
            report.isVerified = "No";
            $scope.report.$update(function () {
            });
        }
    };
}).controller('ReportCreateController', function ($scope, $state, $stateParams, Report,$rootScope) {
    $scope.report = new Report();  //create new report instance. Properties will be set via ng-model on UI

    $scope.addReport = function () { //create a new report. Issues a POST to /api/v1/reports
        $scope.report.$save(function () {
            $state.go('home'); // on success go back to the home page
        });
    };

    $scope.getReportType = function () {
        //TODO Write code that holds the state of the report type (currently if refresh, then lose state) !$stateParams!
        return $rootScope.reportType;
    };
}).controller('ReportEditController', function ($scope, $state, $stateParams, Report) {
    $scope.updateReport = function() { //Update the edited report. Issues a PUT to /api/v1/reports/:id
        $scope.report.$update(function() {
            $state.go('reports'); // on success go back to the home page
        });
    };

    $scope.loadReport = function () { //Issues a GET request to /api/v1/reports/:id to get a report to update
        $scope.report = Report.get({id: $stateParams.id});
    };

    $scope.loadReport(); // Load a report which can be edited on UI
}).controller('ChooseReportTypeController', function ($scope, $state, $stateParams, $rootScope) {
    $scope.reportType = 'views/_no_action_form.html';

    $scope.chooseReport = function () {
        //TODO Could improve this code here, see editShipwreck({id:shipwreck.id}) formatting
        var x = document.getElementById("option");
        var choice = x.options[x.selectedIndex].text;
        if (choice == "No Action") {
            $state.go('newReport');
            $rootScope.reportType = ('views/_no_action_form.html');
        } else if (choice == "investigation") {

        } else if (choice == "intervention") {

        } else if (choice == "inMotion") {

        } else {
            alert("Please select an option");
        }
    };

}).controller('ReportSearchController', function ($scope, $state, $stateParams, Report) {
    //TODO Write a method to verify users credentials
    $scope.reports = Report.query(); //fetch all reports. Issues a GET to /api/vi/reports

    // $scope.enterPressed = function (e) {
    //     if (e.which == 13 || e.keyCode == 13) {
    //         $scope.searchReport();
    //     }
    // };

//     $scope.searchReport = function () {
// // TODO Return specific data values
//         $state.go('reports');
//         $scope.reports = Report.query(); //fetch all reports. Issues a GET to /api/vi/reports
//     };
}).controller('LoginController', function ($scope, $state, $stateParams,$rootScope, User) {
    $scope.verifyUser = function () { //Issues a GET request to /api/v1/users/:id to get a user to verify
        var uname = $scope.User.userName;
        var password = $scope.User.password;
        var userPromise = User.get({userName: uname});
        userPromise.$promise.then(
            function(answer){
                if(answer.password == password){
                    $state.go('home');
                }
            }
        );

        // if($scope.user != null){
        //     $rootScope.userName = $scope.user.userName;
        //     $state.go('home');
        // }
    };
});

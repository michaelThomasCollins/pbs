angular.module('app.controllers', []).controller('ReportViewController', function ($scope, $state, $stateParams, popupService, $window, $filter, $rootScope, Report) {

    /**
     * Returns a report that is loaded from memory
     */
    $scope.getReport = function () {
        $scope.report = Report.get({id: $stateParams.id});
        console.log("Report loaded: " + $scope.report);
    };

    // Call this method on controller startup so that we have the desired report to be viewed
    $scope.getReport();

    /**
     * Deletes a report based on ID
     * @param report
     */
    $scope.deleteReport = function (report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
        if (sessionStorage.getItem('permissions') == "Officer") {
            if (popupService.showPopup('Really delete this?')) {
                report.$delete(function () {
                    $state.go('reports');
                }, function (error) {
                    console.log('Error:> ' + error); // On error alert the user that the function never executed properly
                    alert('Error Deleting Report');
                });
            }
        } else {
            alert("You are not permitted to access this functionality!");
        }
    };

    /**
     * Allows a verifier to confirm a report has been verified
     * @param report
     */
    $scope.verifyReport = function (report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
        if (sessionStorage.getItem('permissions') == "Verifier") {
            if (popupService.showPopup('Are you sure?')) {
                report.isVerified = "Yes";
                $scope.report.$update(function () {
                }, function (error) {
                    console.log('Error:> ' + error); // On error alert the user that the function never executed properly
                    alert('Error Updating Report');
                });
            }
        } else {
            alert("You are not permitted to access this functionality!");
        }
    };

    /**
     * Allows a user to deny a report
     * @param report
     */
    $scope.denyReport = function (report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
        if (sessionStorage.getItem('permissions') == "Verifier") {
            if (popupService.showPopup('Are you sure?')) {
                report.isVerified = "No";
                $scope.report.$update(function () {
                }, function (error) {
                    console.log('Error:> ' + error); // On error alert the user that the function never executed properly
                    alert('Error Updating Report');
                });
            }
        } else {
            alert("You are not permitted to access this functionality!");
        }
    };
    $scope.getReportType = function () {
        return 'views/_' + $scope.report.reportType + '_form.html';
    };
    $scope.getPermissions = function () {
        return sessionStorage.getItem('permissions')
    };
}).controller('ReportCreateController', function ($scope, $state, $stateParams, Report) {
    $scope.report = new Report();  //create new report instance. Properties will be set via ng-model on UI

    /**
     * create a new report. Issues a POST to /api/v1/reports
     */
    $scope.addReport = function () {
        $scope.report.$newReport({type: sessionStorage.getItem('newReportType')}, function(response){
            $state.go('home'); // on success go back to the home page
            console.log('success', response);
        }, function (error) {
            console.log('Error:> ' + error); // On error alert the user that the function never executed properly
            alert('Error Creating Report');
        });

    };

    $scope.getPermissions = function () {
        return sessionStorage.getItem('permissions')
    };

    $scope.getReportType = function () {
        return 'views/_' + sessionStorage.getItem('newReportType') + '_form.html';
    };
}).controller('ReportEditController', function ($scope, $state, $stateParams, $rootScope, Report) {
    $scope.report = new Report();  //create new report instance. Properties will be set via ng-model on UI

    /**
     * Update the edited report. Issues a PUT to /api/v1/reports/:id
     */
    $scope.updateReport = function () {
        $scope.report.$update({type: $scope.report.reportType}, function (response) {
            $state.go('reports'); // on success go back to the home page
            console.log('success', response);
        }, function (error) {
            console.log('Error:> ' + error); // On error alert the user that the function never executed properly
            alert('Error Updating Report');
        });
    };

    $scope.getReportType = function () {
        return 'views/_' + $scope.report.reportType + '_form.html';
    };

    $scope.getPermissions = function () {
        return sessionStorage.getItem('permissions')
    };

    /**
     * Loads the users desired report
     * @return report
     */
    $scope.loadReport = function () { //Issues a GET request to /api/v1/reports/:id to get a report to update
        $scope.report = Report.get({id: $stateParams.id});
    };

    $scope.loadReport(); // Load a report which can be edited on UI
}).controller('ChooseReportTypeController', function ($scope, $state) {

    /**
     * Gets the users chosen report type from the UI then opens it
     */
    $scope.chooseReport = function () {
        //TODO Could improve this code here, see editShipwreck({id:shipwreck.id}) formatting
        var x = document.getElementById("option");
        var choice = x.options[x.selectedIndex].text;
        if (choice == "No Action") {
            sessionStorage.setItem('newReportType','no_action');
            $state.go('newReport');
        } else if (choice == "Investigation") {
            sessionStorage.setItem('newReportType','investigation');
            $state.go('newReport');
        } else if (choice == "Intervention") {
            sessionStorage.setItem('newReportType','intervention');
            $state.go('newReport');
        } else if (choice == "In Motion") {
            sessionStorage.setItem('newReportType','in_motion');
            $state.go('newReport');
        } else {
            alert("Please select an option");
        }
    };

}).controller('ReportSearchController', function ($scope, $state, $stateParams, Search, Report) {
    $scope.report = new Report();

    /**
     * Searches through the reports to find the ones which match the given criteria on UI
     */
    $scope.searchReports = function () {
        // Get details from UI
        var reportId = $scope.Report.id;
        var reportDate = $scope.Report.reportDate;
        var officerId = $scope.Report.officerId;
        var reportName = $scope.Report.reportName;

        sessionStorage.setItem('searchData',reportId + ';' + reportDate + ';' + officerId + ';' + reportName);

        $state.go('reports');
    };
    $scope.reports = Search.query({searchData: sessionStorage.getItem('searchData')}); //fetch all reports. Issues a GET to /api/vi/reports
}).controller('LoginController', function ($scope, $state, $stateParams, $rootScope, User) {
    /**
     * Confirms the user details on the login page
     */
    $scope.verifyUser = function () { //Issues a GET request to /api/v1/users/:id to get a user to verify
        var userName = $scope.User.userName;
        var password = $scope.User.password;
        var userPromise = User.get({userName: userName});
        userPromise.$promise.then(
            function (answer) {
                if (answer.password == password) {
                    sessionStorage.setItem('permissions', answer.permissions);
                    sessionStorage.setItem('userName', answer.userName);
                    $state.go('home');
                } else {
                    alert('Incorrect Data');
                }
            }
        );
    };
}).controller('HomeController', function ($scope, $state) {
    $scope.getPermissions = function () {
        return sessionStorage.getItem('permissions')
    };
    $scope.getUserName = function () {
        return sessionStorage.getItem('userName')
    };

    /**
     * Clears all current user data and returns user to the login page
     */
    $scope.logOut = function () {
        sessionStorage.clear();
        $state.go('login')
    };
});

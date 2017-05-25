angular.module('app.controllers', []).controller('ReportViewController', function ($scope, $state, $stateParams, popupService, $window, $filter, $rootScope, Report) {

    $scope.getReport = function () {
        $scope.report = Report.get({id: $stateParams.id});
        var reportt = $scope.report;
        console.log(reportt);
        // var reportType = "investigation";
        // if (reportType == "no_action") {
        //     $scope.report = Report.getNoAction({id: $stateParams.id}); //Get a single report.Issues a GET to /api/v1/reports/:id
        // } else if (reportType == "investigation") {
        //     $scope.report = Report.getInvestigation({id: $stateParams.id}); //Get a single report.Issues a GET to /api/v1/reports/:id
        // } else if (reportType == "intervention") {
        //     $scope.report = Report.getIntervention({id: $stateParams.id}); //Get a single report.Issues a GET to /api/v1/reports/:id
        // } else if (reportType == "in_motion") {
        //     $scope.report = Report.getInMotion({id: $stateParams.id}); //Get a single report.Issues a GET to /api/v1/reports/:id
        // }
    };

    // Call this method on controller startup so that we have the desired report to be viewed
    $scope.getReport();

    $scope.deleteReport = function (report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
        if (sessionStorage.getItem('permissions') == "Officer") {
            if (popupService.showPopup('Really delete this?')) {
                report.$delete(function () {
                    $state.go('reports');
                });
            }
        } else {
            alert("You are not permitted to access this functionality!");
        }
    };

    $scope.verifyReport = function (report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
        if (sessionStorage.getItem('permissions') == "Verifier") {
            if (popupService.showPopup('Are you sure?')) {
                report.isVerified = "Yes";
                $scope.report.$update(function () {
                });
            }
        } else {
            alert("You are not permitted to access this functionality!");
        }
    };

    $scope.denyReport = function (report) { // Delete a Report. Issues a DELETE to /api/v1/reports/:id
        if (sessionStorage.getItem('permissions') == "Verifier") {
            if (popupService.showPopup('Are you sure?')) {
                report.isVerified = "No";
                $scope.report.$update(function () {
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
    // $scope.report.reportType = sessionStorage.newReportType;

    // $scope.getReport = function () {
    //     var reportType = sessionStorage.newReportType;
    //     if (reportType == "no_action") {
    //         // $scope.report = new NoAction();
    //     } else if (reportType == "investigation") {
    //         // $scope.report = new Investigation();
    //     } else if (reportType == "intervention") {
    //         // $scope.report = new Intervention();
    //     } else if (reportType == "in_motion") {
    //         // $scope.report = new InMotion();
    //     } else {
    //         $scope.report = new Report();
    //     }
    // };

    // Call this method on controller startup so that we have the desired report to be viewed
    // $scope.getReport();

    $scope.addReport = function () { //create a new report. Issues a POST to /api/v1/reports
        // $scope.report.newReport.newReport(function () {
        //     $state.go('home'); // on success go back to the home page
        // });
        $scope.report.$newReport({type: sessionStorage.newReportType}, function(response){
            $state.go('home'); // on success go back to the home page
            console.log('success', response);
        });

    };

    $scope.getPermissions = function () {
        return sessionStorage.getItem('permissions')
    };

    $scope.getReportType = function () {
        return 'views/_' + sessionStorage.newReportType + '_form.html';
    };
}).controller('ReportEditController', function ($scope, $state, $stateParams, $rootScope, Report) {
    $scope.report = new Report();  //create new report instance. Properties will be set via ng-model on UI

    $scope.updateReport = function () { //Update the edited report. Issues a PUT to /api/v1/reports/:id
        $scope.report.$update(function () {
            $state.go('reports'); // on success go back to the home page
        });
    };

    $scope.getReportType = function () {
        return 'views/_' + $scope.report.reportType + '_form.html';
    };

    $scope.getPermissions = function () {
        return sessionStorage.getItem('permissions')
    };

    $scope.loadReport = function () { //Issues a GET request to /api/v1/reports/:id to get a report to update
        $scope.report = Report.get({id: $stateParams.id});
    };

    $scope.loadReport(); // Load a report which can be edited on UI
}).controller('ChooseReportTypeController', function ($scope, $state, $stateParams, $rootScope) {

    $scope.chooseReport = function () {
        //TODO Could improve this code here, see editShipwreck({id:shipwreck.id}) formatting
        var x = document.getElementById("option");
        var choice = x.options[x.selectedIndex].text;
        if (choice == "No Action") {
            sessionStorage.newReportType = ('no_action');
            $state.go('newReport');
        } else if (choice == "Investigation") {
            sessionStorage.newReportType = ('investigation');
            $state.go('newReport');
        } else if (choice == "Intervention") {
            sessionStorage.newReportType = ('intervention');
            $state.go('newReport');
        } else if (choice == "In Motion") {
            sessionStorage.newReportType = ('in_motion');
            $state.go('newReport');
        } else {
            alert("Please select an option");
        }
    };

}).controller('ReportSearchController', function ($scope, $state, $stateParams, Search, Report) {
    //TODO Write a method to verify users credentials
    $scope.report = new Report();

    $scope.searchReports = function () {
        var reportId = $scope.Report.id;
        var reportDate = $scope.Report.reportDate;
        var officerId = $scope.Report.officerId;
        var reportName = $scope.Report.reportName;

        sessionStorage.searchData = reportId + ';' + reportDate + ';' + officerId + ';' + reportName;

        $state.go('reports');
    };
    $scope.reports = Search.query({searchData: sessionStorage.searchData}); //fetch all reports. Issues a GET to /api/vi/reports
}).controller('LoginController', function ($scope, $state, $stateParams, $rootScope, User) {
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

    $scope.logOut = function () {
        sessionStorage.clear();
        $state.go('login')
    };
});

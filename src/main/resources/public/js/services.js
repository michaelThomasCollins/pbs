angular.module('app.services', []).factory('Report', function ($resource) {
    return $resource('/api/v1/reports/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
}).factory('User', function ($resource) {
    return $resource('/api/v1/users/:userName', {userName: '@userName'}, {
        get: {
            method: 'GET'
            // isArray: true
        }
    });
}).service('popupService', function ($window) {
    this.showPopup = function (message) {
        return $window.confirm(message);
    }
}).service('reportTypeService', function () {
    var reportType = 'null';

    return {
        getReportType: function () {
            return reportType;
        },
        setReportType: function (value) {
            reportType = value;
        }
    };
});

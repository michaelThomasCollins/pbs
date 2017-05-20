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
        }
    });
}).factory('Search', function ($resource) {
    return $resource('/api/v1/search/:searchData', {searchData: '@searchData'}, {
        get: {
            method: 'GET'
        },
        query: {
            method: 'GET',
            isArray: true
        }
    });
}).service('popupService', function ($window) {
    this.showPopup = function (message) {
        return $window.confirm(message);
    }
});

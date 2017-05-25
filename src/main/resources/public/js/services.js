angular.module('app.services', []).factory('Report', function ($resource) {
    var base = '/api/v1/reports';
    return $resource('/api/v1/reports', {id: '@id', type: '@type'}, {
        update: {
            url: base + '/:id',
            id: '@id',
            method: 'PUT'
        },
        get: {
            url: base + '/:id',
            id: '@id',
            method: 'GET'
        },
        save: {
            url: base + '/:id',
            id: '@id',
            method: 'POST'
        },
        query: {
            url: base + '/:id',
            id: '@id',
            method: 'GET',
            isArray: true
        },
        remove: {
            url: base + '/:id',
            id: '@id',
            method: 'DELETE'
        },
        delete: {
            url: base + '/:id',
            id: '@id',
            method: 'DELETE'
        },
        newReport: {
            url: base + '/:type',
            type: '@type',
            method: 'POST'
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

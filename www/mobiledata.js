module.exports = {

    check: function (success, failure) {
        cordova.exec(
            success,
            failure,
            "MobileData",
            'check',
            []
        );
    },

    enable: function (success, failure) {
        cordova.exec(
            success,
            failure,
            "MobileData",
            'enable',
            []
        );
    },

    disable: function (success, failure) {
        cordova.exec(
            success,
            failure,
            "MobileData",
            'disable',
            []
        );
    },

    toggle: function (success, failure) {
        cordova.exec(
            success,
            failure,
            "MobileData",
            'toggle',
            []
        );
    }
};
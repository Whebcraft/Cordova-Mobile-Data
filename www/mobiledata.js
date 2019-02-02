var exec = require("cordova/exec");

module.exports = {

    check: function (success, failure) {
        exec(success, failure, "MobileData", "check", []);
    },

    enable: function (success, failure) {
        exec(success, failure, "MobileData", "enable", []);
    },

    disable: function (success, failure) {
        exec(success, failure, "MobileData", "disable", []);
    },

    toggle: function (success, failure) {
        exec(success, failure, "MobileData", "toggle", []);
    }
};
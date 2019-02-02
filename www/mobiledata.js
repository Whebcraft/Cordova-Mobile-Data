module.exports = {

    check:function(success, failure) {
        cordova.exec(
            success,
            failure,
            "mobiledata", 
            'check',
            []
        );
    },

    enable:function(success, failure) {
        cordova.exec(
            success,
            failure,
            "mobiledata", 
            'enable',
            []
        );
    },
    
    disable:function(success, failure) {
        cordova.exec(
            success,
            failure,
            "mobiledata", 
            'disable',
            []
        );
    },
    
    toggle:function(success, failure) {
        cordova.exec(
            success,
            failure,
            "mobiledata", 
            'toggle',
            []
        );
    }     
};
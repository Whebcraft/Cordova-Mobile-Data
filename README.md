# Cordova-Mobile-Data
This plugin set / gets the Mobile data state.

This Plugin Requires https://github.com/Whebcraft/System_api.git

## Installation

```bash
cordova plugin add https://github.com/Whebcraft/Cordova-Mobile-Data.git
```

## **Enable:** 

```javascript
cordova.plugins.MobileData.enable(function(data) {
  data.enabled === true    // enabled
}, function(error) {
  // Error
});
```

---

## **Disable:** 

```javascript
cordova.plugins.MobileData.disable(function(data) {
  data.enabled === false    // disabled
}, function(error) {
  // Error
});
```

---

## **Toggle:** 

```javascript
cordova.plugins.MobileData.toggle(function(data) {
  console.log(data.enabled);
}, function(error) {
  // Error
});
```

---

## **Check:** 

```javascript
cordova.plugins.MobileData.check(function() {
  console.log(data.enabled);
}, function(error) {
  // Error
});
```
# Cordova-Mobile-Data
This plugin set / gets the Mobile data state.

This Plugin Requires https://github.com/Whebcraft/System_api.git

##

```bash
cordova plugin add https://github.com/Whebcraft/Cordova-Mobile-Data.git
```

## com.webcraft.mobiledata

## **Enable:** 

```javascript
window.mobiledata.enable(function(data) {
  data.enabled === true    // enabled
}, function(error) {
  // Error
});
```

---

## **Disable:** 

```javascript
window.mobiledata.disable(function(data) {
  data.enabled === false    // disabled
}, function(error) {
  // Error
});
```

---

## **Toggle:** 

```javascript
window.mobiledata.toggle(function(data) {
  console.log(data.enabled);
}, function(error) {
  // Error
});
```

---

## **Check:** 

```javascript
window.mobiledata.check(function() {
  console.log(data.enabled);
}, function(error) {
  // Error
});
```
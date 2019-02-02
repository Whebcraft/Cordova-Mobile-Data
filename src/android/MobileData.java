package com.webcraft.mobiledata;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MobileData extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        try {

            Context ctx = this.cordova.getActivity();

            final ConnectivityManager conman = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            final Class<?> conmanClass = Class.forName(conman.getClass().getName());
            final Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
            iConnectivityManagerField.setAccessible(true);
            final Object iConnectivityManager = iConnectivityManagerField.get(conman);
            final Class<?> iConnectivityManagerClass = Class.forName(iConnectivityManager.getClass().getName());

            final Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
            setMobileDataEnabledMethod.setAccessible(true);

            TelephonyManager telephonyManager = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);

            if (action.equals("check")) {

                if (telephonyManager.getDataState() == TelephonyManager.DATA_CONNECTED ||
                        telephonyManager.getDataState() == TelephonyManager.DATA_SUSPENDED) {

                    callbackContext.success(new JSONObject().put("enabled", true));
                } else if (telephonyManager.getDataState() == TelephonyManager.DATA_DISCONNECTED) {
                    callbackContext.success(new JSONObject().put("enabled", false));
                }
            }

            if (action.equals("toggle")) {
                if (telephonyManager.getDataState() == TelephonyManager.DATA_CONNECTED) {
                    setMobileDataEnabledMethod.invoke(iConnectivityManager, false);
                    callbackContext.success(new JSONObject().put("enabled", false));
                } else if (telephonyManager.getDataState() == TelephonyManager.DATA_DISCONNECTED) {
                    setMobileDataEnabledMethod.invoke(iConnectivityManager, true);
                    callbackContext.success(new JSONObject().put("enabled", true));
                }
            }

            if (action.equals("enable")) {
                setMobileDataEnabledMethod.invoke(iConnectivityManager, true);
                callbackContext.success(new JSONObject().put("enabled", true));
            }


            if (action.equals("disable")) {
                setMobileDataEnabledMethod.invoke(iConnectivityManager, false);
                callbackContext.success(new JSONObject().put("enabled", false));
            }

        } catch (Exception e) {
            e.printStackTrace();
            //callbackContext.error(e.message);
        }

        return true;
    }
}
package com.vntechnology.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.media.*;

public class WifiHandler extends CordovaPlugin {

    public static final String WIFILIST = "getWifiAvailable";
    public static final String WIFISTATUS = "getWifiStatus";
    private static final String TAG = "WifiHandler";

    private Context context;


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        boolean actionState = true;
        context = cordova.getActivity().getApplicationContext();
       

        if (WIFILIST.equals(action)) {
            try {
                WifiManager wifiManager = (WifiManager)
                   context.getSystemService(Context.WIFI_SERVICE);

                BroadcastReceiver wifiScanReceiver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context c, Intent intent) {
                        boolean success = intent.getBooleanExtra(
                                        WifiManager.EXTRA_RESULTS_UPDATED, false);
                        if (success) {
                              List<ScanResult> results = wifiManager.getScanResults();
                              // Send a positive result to the callbackContext
                              callbackContext.success(results);
                        } else {
                        // scan failure handling
                            List<ScanResult> results = wifiManager.getScanResults();
                            callbackContext.error(results);

                        }
                    }
                };

                // Send a positive result to the callbackContext
                callbackContext.success(carrierName);
                
            } catch(Exception e) {
                //callbackContext.error(e);
                LOG.d(TAG, "ERROR: " + e);
                actionState = false;
            }
            
        }
        else if (WIFISTATUS.equals(action)) {
            try {
                

                // Send a positive result to the callbackContext
                callbackContext.success(carrierName);
                
            } catch(Exception e) {
                //callbackContext.error(e);
                LOG.d(TAG, "ERROR: " + e);
                actionState = false;
            }
            
        }
        
        else {
            actionState = false;
        }
        return actionState;
    }

}
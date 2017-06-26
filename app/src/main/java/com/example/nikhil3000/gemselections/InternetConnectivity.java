package com.example.nikhil3000.gemselections;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by anonymous on 20/6/17.
 */

public class InternetConnectivity extends BroadcastReceiver {

    public static boolean ISCONNECTED=true;

    @Override
    public void onReceive(Context context, Intent intent) {
        ISCONNECTED = isInternetAvailable(context);}

    public InternetConnectivity(Context context) {
        ISCONNECTED = isInternetAvailable(context);
    }
    public InternetConnectivity(){}

    private boolean isInternetAvailable(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }
}

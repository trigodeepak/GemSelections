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

    private ConnectivityManager manager;
    private boolean state1, state2;
    public boolean STATUS;

    @Override
    public void onReceive(Context context, Intent intent) {
        STATUS = isInternetAvailable(context);
    }

    public InternetConnectivity(){
        super();
    }

    public InternetConnectivity(Context context) {
        STATUS = isInternetAvailable(context);
    }

    public boolean isInternetAvailable(Context context){
        manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        state1 = (manager.getNetworkInfo(0).getState()== NetworkInfo.State.CONNECTED);
        state2 = (manager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED);
        return state1 || state2;
    }
}

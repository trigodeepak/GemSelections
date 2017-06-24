package com.example.nikhil3000.gemselections;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

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

        //Just for test
        if(!STATUS){
            Toast.makeText(context.getApplicationContext(), "Internet Not Available", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context.getApplicationContext(), "Internet Available", Toast.LENGTH_SHORT).show();
        }
    }

    public InternetConnectivity(){
        super();
    }

    public InternetConnectivity(Context context) {
        STATUS = isInternetAvailable(context);
    }

    /*private boolean isOnline(Context context) {
        manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        return (info !=null && info.isConnected());
    }*/

    public boolean isInternetAvailable(Context context){
        manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        state1 = (manager.getNetworkInfo(0).getState()== NetworkInfo.State.CONNECTED);
        state2 = (manager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED);
        if(state1 == true || state2== true){
            return true;
        }else {
            return false;
        }
    }
}

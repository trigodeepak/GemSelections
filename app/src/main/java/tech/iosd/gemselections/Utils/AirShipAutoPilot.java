package tech.iosd.gemselections.Utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;

import tech.iosd.gemselections.BuildConfig;
import tech.iosd.gemselections.R;

/**
 * Created by anubhavmalik on 11/03/18.
 */

public class AirShipAutoPilot extends Autopilot {


    @Override
    public void onAirshipReady(UAirship airship) {
        airship.getPushManager().setUserNotificationsEnabled(true);

        if (Build.VERSION.SDK_INT >= 26) {
            Context context = UAirship.getApplicationContext();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            NotificationChannel channel = new NotificationChannel("customChannel",
                    context.getString(R.string.custom_channel_name),
                    NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(channel);
        }

    }

//    @Nullable
//    @Override
//    public AirshipConfigOptions createAirshipConfigOptions(@NonNull Context context) {

//        AirshipConfigOptions options = new AirshipConfigOptions.Builder()
//                .setDevelopmentAppKey("Your Development App Key")
//                .setDevelopmentAppSecret("Your Development App Secret")
//                .setProductionAppKey("Your Production App Key")
//                .setProductionAppSecret("Your Production App Secret")
//                .setInProduction(!BuildConfig.DEBUG)
//                .setFcmSenderId("980508632732")
//                .setNotificationIcon(R.mipmap.ic_launcher)
//                .setNotificationAccentColor(context.getResources().getColor(R.color.colorAccent))
//                .setNotificationChannel("customChannel")
//                .build();
//
//        return options;
//
//        return super.createAirshipConfigOptions(context);
//
//    }
}
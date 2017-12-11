package tech.iosd.gemselections.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by anonymous on 20/6/17.
 */

public class CheckFirstTime {
    public boolean isFirstTime(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences("Gemselections", Context.MODE_PRIVATE);

        if(preferences.getBoolean("firstTime",true)){

            preferences.edit().putBoolean("firstTime", false).apply();
            return true;
        }
        else {
            return false;
        }
    }
}

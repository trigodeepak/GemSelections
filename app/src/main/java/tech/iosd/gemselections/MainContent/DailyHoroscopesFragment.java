package tech.iosd.gemselections.MainContent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tech.iosd.gemselections.R;

/**
 * Created by anubhavmalik on 05/03/18.
 */

public class DailyHoroscopesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_daily_horoscope,container,false);


        return view;
    }
}

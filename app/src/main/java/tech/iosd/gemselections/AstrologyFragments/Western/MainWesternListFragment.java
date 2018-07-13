package tech.iosd.gemselections.AstrologyFragments.Western;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import tech.iosd.gemselections.AstrologyFragments.RequestFragments.WesternComplexDataCollectorFragment;
import tech.iosd.gemselections.AstrologyFragments.RequestFragments.WesternDataCollectorOneFragment;
import tech.iosd.gemselections.AstrologyFragments.RequestFragments.WesternZodiacCompatibilityDataCollectionFragment;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class MainWesternListFragment extends Fragment {

    String[] array = {
            "Western Horoscope"
            , "Western Chart"
            , "Daily Tropical Transit"
            , "Weekly Tropical Transit"
            , "Monthly Tropical Transit"
            , "Solar Return"
            , "Solar Return Planet"
            , "Solar Return House"
            , "Lunar Metrics"
            , "Composite Horoscope"
            , "Synastry Horoscope"
            , "Personality Report"
            , "Romantic Personality Report"
            , "Personalized Planet Prediction"
            , "Life Forecast Report"
            , "Romantic Forecast Report"
            , "Friendship Report"
            , "Karma Destiny Report"
            , "Love Compatibility Report"
            , "Romantic Forecast Couple Report"
            , "Zodiac Compatibility"
            , "Sun Sign Compatibility"};

    Fragment fragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.astro_western_list_frag, container, false);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, array);

        ListView listView = view.findViewById(R.id.western_astrology_list_view);
        listView.setAdapter(arrayAdapter);

        final Bundle bundle = new Bundle();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //todo romantic personality report
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    //Calling the basic fragment of these cases
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    //Now cases for Western Complex Data Fragment
                    case 9:
                    case 10:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        fragment = new WesternComplexDataCollectorFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    //Call next Fragment WesternZodiacCompatibilityDataCollectionFragment
                    case 20:
                    case 21:
                        fragment = new WesternZodiacCompatibilityDataCollectionFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                }
                fragment.setArguments(bundle);
                setFragment(fragment);
            }
        });
        return view;
    }

    public void setFragment (Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.western_astrology_container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main")
                .commit();
    }
}

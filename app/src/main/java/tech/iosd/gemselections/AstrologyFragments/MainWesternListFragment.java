package tech.iosd.gemselections.AstrologyFragments;

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

import tech.iosd.gemselections.R;

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
            , "Sunsign Compatibility"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.astro_western_list_frag, container, false);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, array);

        ListView listView = view.findViewById(R.id.western_astrology_list_view);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        setFragment(new WesternHoroscopeFragment());
                        break;
                    case 1:
                        setFragment(new WesternChartFragment());
                        break;
                    case 2:
                        setFragment(new DailyTransitsFragment());
                        break;
                    case 3:
                        setFragment(new WeeklyTransitFragment());
                        break;
                    case 4:
                        setFragment(new MonthlyTransitFragment());
                        break;
                    case 5:
                        setFragment(new SolarReturnFragment());
                        break;
                    case 6:
                        setFragment(new SolarReturnPlanetFragment());
                        break;
                    case 7:
                        setFragment(new SolarReturnHouseFragment());
                        break;
                    case 8:
                        setFragment(new LunarMetricsFragment());
                        break;
                    case 9:
                        setFragment(new CompositeHoroscopeFragment());
                        break;
                    case 10:
                        setFragment(new SynastryFragment());
                        break;
                    case 11:
                        setFragment(new PersonalityReportFragment());
                        break;
                    case 12:
                        setFragment(new RomanticPersonalityFragment());
                        break;
                    case 13:
                        setFragment(new PersonalizedPlanetPredictionFragment());
                        break;
                    case 14:
                        setFragment(new LifeForecastFragment());
                        break;
                    case 15:
                        setFragment(new RomanticForecastFragment());
                        break;
                    case 16:
                        setFragment(new FriendshipReportFragment());
                        break;
                    case 17:
                        setFragment(new KarmaDestinyFragment());
                        break;
                    case 18:
                        setFragment(new LoveCompatibilityFragment());
                        break;
                    case 19:
                        setFragment(new RomanticForecastCoupleReportFragment());
                        break;
                    case 20:
                        setFragment(new ZodiacCompatibilityFragment());
                        break;
                    case 21:
                        setFragment(new LoveCompatibilityFragment());
                        break;
                }
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

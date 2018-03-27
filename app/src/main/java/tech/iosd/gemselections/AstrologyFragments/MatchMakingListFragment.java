package tech.iosd.gemselections.AstrologyFragments;


import android.os.Bundle;
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
 * A simple {@link Fragment} subclass.
 */
public class MatchMakingListFragment extends Fragment {
    String[] array = {
            "Match Birth Details"
            , "Match Ashtakoot Points"
            , "Match Vedha (Obstructions)"
            , "Match Astro Details"
            , "Match Planet Details"
            , "Match Manglik Report"
            , "Match Making Report"
            , "Match Simple Report"
            , "Match Making detailed Report"
            , "Composite Match Dashakoot Points"
            , "Match percentage"
            , "Partner Report"
            , "Custom Match Profiles"
            , "Papasamyam Details"
            };

    public MatchMakingListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match_making_list, container, false);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, array);

        ListView listView = view.findViewById(R.id.match_making_list_view);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        setFragment(new MatchBirthDetailFragment());
                        break;
                    case 1:
                        setFragment(new MatchAshtakootPointsFragment());
                        break;
                    case 2:
                        setFragment(new MatchVedhaObstructionsFragment());
                        break;
                    case 3:
                        setFragment(new MatchAstroDetailsFragment());
                        break;
                    case 4:
                        setFragment(new MatchPlanetDetailsFragment());
                        break;
                    case 5:
                        setFragment(new MatchManglikReportFragment());
                        break;
                    case 6:
                        setFragment(new MatchMakingReportFragment());
                        break;
                    case 7:
                        setFragment(new MatchSimpleReportFragment());
                        break;
                    case 8:
                        setFragment(new MatchMakingdetailedReportFragment());
                        break;
                    case 9:
                        setFragment(new CompositeMatchDashakootPointsFragment());
                        break;
                    case 10:
                        setFragment(new MatchpercentageFragment());
                        break;
                    case 11:
                        setFragment(new PartnerReportFragment());
                        break;
                    case 12:
                        setFragment(new CustomMatchProfilesFragment());
                        break;
                    case 13:
                        setFragment(new PapasamyamDetailsFragment());
                        break;

                }
            }
        });
        return view;
    }

    public void setFragment (Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.match_making_container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main")
                .commit();
    }
    }



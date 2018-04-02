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
            , "Match Dashakoot Points"
            , "Match percentage"
            , "Partner Report"
            , "Custom Match Profiles"
            , "Papasamyam Details"
    };

    MatchMakingInputFragment1 matchMakingInputFragment1 = new MatchMakingInputFragment1();
    Bundle args = new Bundle();
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


                        args.putInt("caseNo", 0);
                        matchMakingInputFragment1.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("Main").commit();
                        // setFragment(new MatchBirthDetailFragment());
                        break;
                    case 1:


                        args.putInt("caseNo", 1);
                        matchMakingInputFragment1.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("Main").commit();
                       // setFragment(new MatchAshtakootPointsFragment());
                        break;
                    case 2:
                        args.putInt("caseNo", 2);
                        matchMakingInputFragment1.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("Main").commit();
                        //setFragment(new MatchVedhaObstructionsFragment());
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
                        args.putInt("caseNo", 6);
                        matchMakingInputFragment1.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("Main").commit();
                        //setFragment(new MatchMakingReportFragment());
                        break;
                    case 7:
                        args.putInt("caseNo", 7);
                        matchMakingInputFragment1.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("Main").commit();
                       // setFragment(new MatchSimpleReportFragment());
                        break;
                    case 8:

                        args.putInt("caseNo", 8);
                        matchMakingInputFragment1.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("Main").commit();

                        //setFragment(new MatchMakingdetailedReportFragment());
                        break;

                    case 9:
                        args.putInt("caseNo", 9);
                        matchMakingInputFragment1.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("Main").commit();
                      //  setFragment(new MatchDashakootPointsFragment());
                        break;
                    case 10:
                        args.putInt("caseNo", 10);
                        matchMakingInputFragment1.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("Main").commit();
                        //setFragment(new MatchpercentageFragment());
                        break;
                    case 11:
                        args.putInt("caseNo", 11);
                        MatchMakingInputFragment2 matchMakingInputFragment2 = new MatchMakingInputFragment2();
                        matchMakingInputFragment2.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment2).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack("Main").commit();

                       // setFragment(new PartnerReportFragment());
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

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.match_making_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main")
                .commit();
    }
}



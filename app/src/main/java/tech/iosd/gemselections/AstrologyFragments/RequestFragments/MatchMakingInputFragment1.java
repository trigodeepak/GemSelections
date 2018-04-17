package tech.iosd.gemselections.AstrologyFragments.RequestFragments;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import tech.iosd.gemselections.AstrologyFragments.MatchMaking.MatchAshtakootPointsFragment;
import tech.iosd.gemselections.AstrologyFragments.MatchMaking.MatchBirthDetailFragment;
import tech.iosd.gemselections.AstrologyFragments.MatchMaking.MatchDashakootPointsFragment;
import tech.iosd.gemselections.AstrologyFragments.MatchMaking.MatchMakingReportFragment;
import tech.iosd.gemselections.AstrologyFragments.MatchMaking.MatchMakingdetailedReportFragment;
import tech.iosd.gemselections.AstrologyFragments.MatchMaking.MatchPercentageFragment;
import tech.iosd.gemselections.AstrologyFragments.MatchMaking.MatchSimpleReportFragment;
import tech.iosd.gemselections.AstrologyFragments.MatchMaking.MatchVedhaObstructionsFragment;
import tech.iosd.gemselections.R;

/**
 * Created by kushalgupta on 28/03/18.
 */

public class MatchMakingInputFragment1 extends Fragment {
    private TextView mDisplayDate, fDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener fDateSetListener;
    private Button submitButton;
    private EditText mmhtob, mmmtob, mmpob, ffhtob, ffmtob, ffpob;
    private int mmonth, myear, mday, fmonth, fyear, fday, mhtob, mmtob, fhtob, fmtob;
    private String mpob, fpob;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.astrology_matchmaking_input_details, container, false);
        mDisplayDate = (TextView) view.findViewById(R.id.tv_mDate);
        fDisplayDate = view.findViewById(R.id.tv_fDate);
        submitButton = view.findViewById(R.id.bt_submit);
        mmhtob = view.findViewById(R.id.et_mhtob);
        mmmtob = view.findViewById(R.id.et_mmtob);
        mmpob = view.findViewById(R.id.et_mpob);
        ffhtob = view.findViewById(R.id.et_fhtob);
        ffmtob = view.findViewById(R.id.et_fmtob);
        ffpob = view.findViewById(R.id.et_fpob);


        //getting case no from last matchmakinglist fragment
        final int caseNo = getArguments().getInt("caseNo");
        // Toast.makeText(view.getContext(), "argu:"+caseNo, Toast.LENGTH_SHORT).show();

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                //int year = cal.get(Calendar.YEAR);
                myear = 1997;
                mmonth = cal.get(Calendar.MONTH);
                mday = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        view.getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        myear, mmonth, mday);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int myear, int mmonth, int mday) {
                mmonth = mmonth + 1;

                String date = mmonth + "/" + mday + "/" + myear;
                mDisplayDate.setText(date);
            }
        };


        fDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                //int year = cal.get(Calendar.YEAR);
                fyear = 1997;
                fmonth = cal.get(Calendar.MONTH);
                fday = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        view.getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        fDateSetListener,
                        fyear, fmonth, fday);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        fDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int fyear, int fmonth, int fday) {
                fmonth = fmonth + 1;

                String date = fmonth + "/" + fday + "/" + fyear;
                fDisplayDate.setText(date);
            }
        };


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mhtob = Integer.parseInt(mmhtob.getText().toString());
                mmtob = Integer.parseInt(mmmtob.getText().toString());
                fhtob = Integer.parseInt(ffhtob.getText().toString());
                fmtob = Integer.parseInt(ffmtob.getText().toString());
                mpob = mmpob.getText().toString();
                fpob = ffpob.getText().toString();
                if (mhtob != 0 && fhtob != 0 && mmtob != 0 && fmtob != 0 && mpob != null && fpob != null) {
                    Bundle args = new Bundle();
                    args.putInt("mdob", mday);
                    args.putInt("mmob", mmonth);
                    args.putInt("myob", myear);
                    args.putInt("fdob", fday);
                    args.putInt("fmob", fmonth);
                    args.putInt("fyob", fyear);
                    args.putInt("mhtob", mhtob);
                    args.putInt("mmtob", mmtob);
                    args.putInt("fhtob", fhtob);
                    args.putInt("fmtob", fmtob);
                    args.putString("mpob", mpob);
                    args.putString("fpob", fpob);
                    switch (caseNo) {
                        case 0:
                            MatchBirthDetailFragment matchBirthDetailFragment = new MatchBirthDetailFragment();
                            matchBirthDetailFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    matchBirthDetailFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();
                            break;
                        case 1:
                            MatchAshtakootPointsFragment matchAshtakootPointsFragment = new MatchAshtakootPointsFragment();
                            matchAshtakootPointsFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    matchAshtakootPointsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();
                            break;

                        case 2:
                            MatchVedhaObstructionsFragment matchVedhaObstructionsFragment = new MatchVedhaObstructionsFragment();
                            matchVedhaObstructionsFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    matchVedhaObstructionsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();
                            break;
                        case 6:
                            MatchMakingReportFragment matchMakingReportFragment = new MatchMakingReportFragment();
                            matchMakingReportFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    matchMakingReportFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();
                            break;
                        case 7:
                            MatchSimpleReportFragment matchSimpleReportFragment = new MatchSimpleReportFragment();

                            matchSimpleReportFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    matchSimpleReportFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();
                            break;
                        case 8:
                            MatchMakingdetailedReportFragment matchMakingdetailedReportFragment = new MatchMakingdetailedReportFragment();

                            matchMakingdetailedReportFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    matchMakingdetailedReportFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();

                            break;
                        case 9:
                            MatchDashakootPointsFragment matchDashakootPointsFragment = new MatchDashakootPointsFragment();

                            matchDashakootPointsFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    matchDashakootPointsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();
                            break;
                        case 10:
                            MatchPercentageFragment matchPercentageFragment = new MatchPercentageFragment();

                            matchPercentageFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    matchPercentageFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();



                    }
                } else {
                    Toast.makeText(view.getContext(), "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
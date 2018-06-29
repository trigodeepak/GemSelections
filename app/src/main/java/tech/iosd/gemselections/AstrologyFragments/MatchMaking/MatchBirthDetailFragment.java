package tech.iosd.gemselections.AstrologyFragments.MatchMaking;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.AuthRelated.LoginActivity;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchAshtakootPointsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchBirthDetailResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchMakingDetailedReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PredictionResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchBirthDetailFragment extends Fragment {

    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    public static final String TAG = "latlong";
    double mlat,mlongilo,flat,flongilo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_birth_detail_astrology, container, false);
        // getting arguments from matchmakinginputfrag1 getting the whole object
        MatchMakingSimpleRequest matchMakingSimpleRequest = (MatchMakingSimpleRequest) getArguments().getSerializable("match_making_obj");
        Log.d("Check Object",String.valueOf(matchMakingSimpleRequest.getFdob()));

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //todo correct the response code or there is api error
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<MatchBirthDetailResponse> call = astrologyApiInterface.getMatchBirthDetailsResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchBirthDetailResponse>() {
            @Override
            public void onResponse(Call<MatchBirthDetailResponse> call, Response<MatchBirthDetailResponse> response) {
                Log.d("Testing api",String.valueOf(response.body()));
                MatchBirthDetailResponse matchBirthDetailResponse = response.body();
                Log.d("Testing api",String.valueOf(matchBirthDetailResponse));
                Toast.makeText(view.getContext(), "response:" + matchBirthDetailResponse.getMaleBirthDetails(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MatchBirthDetailResponse> call, Throwable t) {

            }
        });
        return view;
    }
}

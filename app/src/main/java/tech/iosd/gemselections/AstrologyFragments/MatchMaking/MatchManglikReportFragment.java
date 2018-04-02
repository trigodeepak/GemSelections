package tech.iosd.gemselections.AstrologyFragments.MatchMaking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.FemalePlanetDetail;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchManglikReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchPlanetDetailsResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */


public class MatchManglikReportFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_manglik_report_astrology, container, false);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchMakingSimpleRequest matchMakingSimpleRequest = new MatchMakingSimpleRequest(17, 03,
                1997, 05, 30, (float) 19.2056, (float) 25.2056, (float) 5.5, 29, 11, 1997, 02, 03, (float) 19.2056, (float) 25.2056, (float) 5.5);
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<MatchManglikReportResponse> call = astrologyApiInterface.getMatchManglikReportResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchManglikReportResponse>() {
            @Override
            public void onResponse(Call<MatchManglikReportResponse> call, Response<MatchManglikReportResponse> response) {
                MatchManglikReportResponse matchManglikReportResponse = response.body();
                // List<FemalePlanetDetail> list = matchPlanetDetailsResponse.getFemalePlanetDetails();
                Toast.makeText(view.getContext(), "response:" + matchManglikReportResponse, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MatchManglikReportResponse> call, Throwable t) {

            }
        });

        return view;
    }
}
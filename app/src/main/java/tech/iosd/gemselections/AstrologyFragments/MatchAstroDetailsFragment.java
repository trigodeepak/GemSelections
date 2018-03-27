package tech.iosd.gemselections.AstrologyFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchAstroDetailsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchObstructionsResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchAstroDetailsFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_astro_details_astrology, container, false);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchMakingSimpleRequest matchMakingSimpleRequest = new MatchMakingSimpleRequest(17, 03,
                1997, 05, 30, (float) 19.2056, (float) 25.2056, (float) 5.5, 29, 11, 1997, 02, 03, (float) 19.2056, (float) 25.2056, (float) 5.5);
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<MatchAstroDetailsResponse> call = astrologyApiInterface.getMatchAstroDetailsResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchAstroDetailsResponse>() {
            @Override
            public void onResponse(Call<MatchAstroDetailsResponse> call, Response<MatchAstroDetailsResponse> response) {
                MatchAstroDetailsResponse matchAstroDetailsResponse = response.body();
                Toast.makeText(view.getContext(), "response:" + matchAstroDetailsResponse, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MatchAstroDetailsResponse> call, Throwable t) {

            }
        });

        return view;
    }
}

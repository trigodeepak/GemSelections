package tech.iosd.gemselections.AstrologyFragments.MatchMaking;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchAstroDetailsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchPlanetDetailsResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchPlanetDetailsFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    TextView report;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_planet_details_astrology, container, false);
        report = view.findViewById(R.id.report);
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Getting request object from previous fragment
        MatchMakingSimpleRequest matchMakingSimpleRequest = (MatchMakingSimpleRequest) getArguments().getSerializable("match_making_obj");
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        //todo correct the response the response is not proper and make layout
        Call<MatchPlanetDetailsResponse> call = astrologyApiInterface.getMAtchPlanetDetailsResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);

        call.enqueue(new Callback<MatchPlanetDetailsResponse>() {
            @Override
            public void onResponse(Call<MatchPlanetDetailsResponse> call, Response<MatchPlanetDetailsResponse> response) {
                progressDialog.dismiss();
                MatchPlanetDetailsResponse matchPlanetDetailsResponse = response.body();
                List<FemalePlanetDetail> list = matchPlanetDetailsResponse.getFemalePlanetDetails();
                Toast.makeText(view.getContext(), "response:" + list.get(0).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MatchPlanetDetailsResponse> call, Throwable t) {

            }
        });

        return view;
    }
}

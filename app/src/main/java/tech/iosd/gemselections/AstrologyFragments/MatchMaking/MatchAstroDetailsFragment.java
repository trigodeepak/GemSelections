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


public class MatchAstroDetailsFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    TextView report;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_astro_details_astrology, container, false);
        //todo Response coming correct have the layout and it will work fine
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
        Call<MatchAstroDetailsResponse> call = astrologyApiInterface.getMatchAstroDetailsResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchAstroDetailsResponse>() {
            @Override
            public void onResponse(Call<MatchAstroDetailsResponse> call, Response<MatchAstroDetailsResponse> response) {
                progressDialog.dismiss();
                MatchAstroDetailsResponse matchAstroDetailsResponse = response.body();
                Toast.makeText(view.getContext(), "response:" + matchAstroDetailsResponse.getMaleAstroDetails().getVarna(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MatchAstroDetailsResponse> call, Throwable t) {

            }
        });

        return view;
    }
}

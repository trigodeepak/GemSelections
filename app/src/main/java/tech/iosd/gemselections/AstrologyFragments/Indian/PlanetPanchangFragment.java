package tech.iosd.gemselections.AstrologyFragments.Indian;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.BasicGemSuggestionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PlanetPanchangResponse;
import tech.iosd.gemselections.Utils.Constants;

public class PlanetPanchangFragment  extends Fragment {
    Retrofit retrofit;
    ArrayList<String> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_report_frag, container, false);

        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        final TextView responseTextView = view.findViewById(R.id.general_report_text_view);

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        Bundle bundle = this.getArguments();
        bundle = new Bundle();
        if (bundle != null) {

            WesternAstrologySimpleRequest westernAstrologySimpleRequest = new WesternAstrologySimpleRequest(20, 2, 1992, 12, 12, Constants.PRIMARY_LAT, Constants.PRIMARY_LNG, Constants.TIMEZONE);
//                = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY,1)
//                ,bundle.getInt(Constants.PRIMARY_MONTH,1)
//                ,bundle.getInt(Constants.PRIMARY_YEAR,2018)
//                ,bundle.getInt(Constants.PRIMARY_HOUR,1)
//                ,bundle.getInt(Constants.PRIMARY_MIN,1)
//                ,Constants.PRIMARY_LAT
//                ,Constants.PRIMARY_LNG
//                ,Constants.TIMEZONE);


            Call<List<PlanetPanchangResponse>> call = astrologyApiInterface
                    .getPlanetPanchang(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

            call.enqueue(new Callback<List<PlanetPanchangResponse>>() {
                @Override
                public void onResponse(Call<List<PlanetPanchangResponse>> call, Response<List<PlanetPanchangResponse>> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful() && response.body() != null) {
//                        String responseString = "";
                        Log.d("TAGGER", "RESPONSE SUCCESS");
//                            responseString = responseString.concat(response.body().getReport().get(i));
                        try {
                            responseTextView.append("\n\nPlanet Panchang : \n");

                            for(int i  = 0 ; i <response.body().size() ; i++) {
                                responseTextView.append("\n\t\tName : " + response.body().get(i).getName());
                                responseTextView.append("\n\t\tFull Degree : " + response.body().get(i).getFullDegree());
                                responseTextView.append("\n\t\tNorm Degree : " + response.body().get(i).getNormDegree());
                                responseTextView.append("\n\t\tRetro : " + response.body().get(i).isIsRetro());
                                responseTextView.append("\n\t\tSign : " + response.body().get(i).getSign());
                                responseTextView.append("\n\t\tSign Lord : " + response.body().get(i).getSignLord());
                                responseTextView.append("\n\t\tNakshatra : " + response.body().get(i).getNakshatra());
                                responseTextView.append("\n\t\tNakshatra Lord : " + response.body().get(i).getNakshatraLord()+"\n");

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<PlanetPanchangResponse>> call, Throwable t) {

                    Log.d("TAGGER", "RESPONSE FAILURE");
                    Log.d("TAGGER", t.getMessage());
                    Snackbar.make(responseTextView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                    progressDialog.dismiss();
                }
            });


        }
        return view;
    }
}
package tech.iosd.gemselections.Retrofit;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tech.iosd.gemselections.Retrofit.ResponseModels.PredictionResponse;

/**
 * Created by anubhavmalik on 04/03/18.
 */

public interface ApiInterface {

    public static final String HEADER_TOKEN = "Basic NjAxNjk2Ojg1MTBlNTM3YmNjNDI0ZTE1NGEzODYwZTcwZTkyMjA5"; //follow convention if using somewhere else

    @POST("sun_sign_prediction/daily/{horoscope}")
    Call<PredictionResponse> getTodaysHoroscope (
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

}

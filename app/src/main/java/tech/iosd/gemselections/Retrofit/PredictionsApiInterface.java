package tech.iosd.gemselections.Retrofit;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tech.iosd.gemselections.Retrofit.ResponseModels.MonthlyPredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.NextPredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.WeeklyPredictionResponse;

/**
 * Created by anubhavmalik on 04/03/18.
 */

public interface PredictionsApiInterface {

    String HEADER_TOKEN = "Basic NjAxNjk2Ojg1MTBlNTM3YmNjNDI0ZTE1NGEzODYwZTcwZTkyMjA5"; //follow convention if using somewhere else

    @POST("sun_sign_prediction/daily/{horoscope}")
    Call<PredictionResponse> getTodaysHoroscope (
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

    @POST("horoscope_prediction/daily/next/{horoscope}")
    Call<NextPredictionResponse> getNextHoroscope (
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

    @POST("horoscope_prediction/daily/previous/{horoscope}")
    Call<NextPredictionResponse> getPreviousHoroscope (
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

    @POST("horoscope_prediction/weekly/{horoscope}")
    Call<WeeklyPredictionResponse> getWeeklyHoroscope(
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

    @POST("horoscope_prediction/monthly/{horoscope}")
    Call<MonthlyPredictionResponse> getMonthlyHoroscope(
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );
}

package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class LifeForecastResponse {

    @SerializedName("life_forecast")
    private List<LifeForecast> lifeForecast = null;

    public List<LifeForecast> getLifeForecast() {
        return lifeForecast;
    }

    public void setLifeForecast(List<LifeForecast> lifeForecast) {
        this.lifeForecast = lifeForecast;
    }

}

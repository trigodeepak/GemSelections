package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anubhavmalik on 06/03/18.
 */

public class MonthlyPredictionResponse implements Serializable {
    @SerializedName("sun_sign")
    private String sunSign;

    @SerializedName("prediction_month")
    private String predictionMonth;

    @SerializedName("prediction")
    private String prediction;

    public MonthlyPredictionResponse() {
    }

    public MonthlyPredictionResponse(String sunSign, String predictionMonth, String prediction) {

        this.sunSign = sunSign;
        this.predictionMonth = predictionMonth;
        this.prediction = prediction;
    }

    public String getSunSign() {
        return sunSign;
    }

    public void setSunSign(String sunSign) {
        this.sunSign = sunSign;
    }

    public String getPredictionMonth() {
        return predictionMonth;
    }

    public void setPredictionMonth(String predictionMonth) {
        this.predictionMonth = predictionMonth;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}

package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/composite_horoscope
public class CompositeHoroscopeResponse {
    @SerializedName("first")
    @Expose
    private List<First> first = null;
    @SerializedName("second")
    @Expose
    private List<Second> second = null;
    @SerializedName("composite")
    @Expose
    private Composite composite;

    public List<First> getFirst() {
        return first;
    }

    public void setFirst(List<First> first) {
        this.first = first;
    }

    public List<Second> getSecond() {
        return second;
    }

    public void setSecond(List<Second> second) {
        this.second = second;
    }

    public Composite getComposite() {
        return composite;
    }

    public void setComposite(Composite composite) {
        this.composite = composite;
    }

}
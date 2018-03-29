package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class House {
    @SerializedName("start_degree")
    @Expose
    private double startDegree;
    @SerializedName("end_degree")
    @Expose
    private double endDegree;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("house_id")
    @Expose
    private long houseId;
    @SerializedName("planets")
    @Expose
    private List<Planet> planets = null;

    public double getStartDegree() {
        return startDegree;
    }

    public void setStartDegree(double startDegree) {
        this.startDegree = startDegree;
    }

    public double getEndDegree() {
        return endDegree;
    }

    public void setEndDegree(double endDegree) {
        this.endDegree = endDegree;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

}

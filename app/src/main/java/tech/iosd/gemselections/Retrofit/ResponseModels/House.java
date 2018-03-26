package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class House {
    @SerializedName("start_degree")
    @Expose
    private double startDegree;
    @SerializedName("end_degree")
    private double endDegree;
    @SerializedName("house")
    @Expose
    private long house;
    @SerializedName("sign")
    @Expose
    private String sign;

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

    @SerializedName("degree")
    @Expose
    private double degree;

    public long getHouse() {
        return house;
    }

    public void setHouse(long house) {
        this.house = house;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }
}

package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class SolarReturnHouseResponse {

    @SerializedName("planet_name")
    @Expose
    private String planetName;
    @SerializedName("house")
    @Expose
    private long house;
    @SerializedName("report")
    @Expose
    private String report;

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public long getHouse() {
        return house;
    }

    public void setHouse(long house) {
        this.house = house;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
